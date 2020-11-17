var startPos = 0;
var endPos = 1;
function handleCreateComment() {  
  var xhr = new XMLHttpRequest();
	var requestData = {};
	requestData["commentId"] = makeid(8);
	requestData["commentText"] = document.getElementById("comment").value;
	var today = new Date(); 
    requestData["commentDate"] = today.toISOString();
	requestData["snippetId"] = document.getElementById("id-textarea").value;
	var textarea = document.getElementById("comment");
	        
	textarea.onclick = function () {
		var substr = textarea.value.substring(0,obj.selectionStart).split('\n');
    	var row = substr.length;
    
    	// if selection spans over
    	if(textarea.selectionStart != textarea.selectionEnd)
    	{
        	substr = textarea.value.substring(textarea.selectionStart, textarea.selectionEnd).split('\n');
        	row += substr.length - 1;
        }
        startPos = row;
	};
	textarea.onkeyup = function () {
	var substr = textarea.value.substring(0,obj.selectionStart).split('\n');
    	var row = substr.length;
    
    	// if selection spans over
    	if(textarea.selectionStart != textarea.selectionEnd)
    	{
        	substr = textarea.value.substring(textarea.selectionStart, textarea.selectionEnd).split('\n');
        	row += substr.length - 1;
        }
        endPos = row;
	};
	
	
	console.log(startPos);
	console.log(endPos);
	if(startPos == endPos){
		showAlert("Select a part of snippet to create a comment!");
		$("#comment").val("");
		return;
	}
	requestData["regionStart"] = startPos;
	requestData["regionEnd"] = endPos;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);

	xhr.open("POST", create_comment_url, true);

	// Send the collected data as JSON
	xhr.send(js);

  // This will process results and update HTML as appropriate. 
  xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
    	 if (xhr.status == 200) {	      
	      updateCommentList(xhr.response);
	      showAlert("New comment is created!");
    	 } else {
    		  var js = JSON.parse(xhr.response);
			  var err = js["response"];
			  alert (err);
    	 }
    } else {
      
    }
  };
}

function updateCommentList(resp){
	var i;
	var commentList = document.getElementById('commentList');
	
	//clear commentList
	commentList.innerHTML = '';
	
	var jsonArray = JSON.parse(resp).list;
	
	for (i in jsonArray) {
		var commentText = jsonArray[i].commentText;
	
		// Button for snippet
		var commentBtn = document.createElement("BUTTON");
		var t = document.createTextNode(commentText);
		
		commentBtn.setAttribute("style","color:black;font-size:15px");
		commentBtn.appendChild(t);
		
		commentList.appendChild(commentBtn);
	}
}

// Dynamically load list of comments
function loadComments(snippetId) {
	var xhr = new XMLHttpRequest();
	
	// send POST to get list of all comments
	var requestData = {};
	requestData["snippetId"] = snippetId;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);
    xhr.open("POST", view_comments_url, true);
	// send request
	xhr.send(js);
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{
			var resp = xhr.response;
			updateCommentList(resp);
		} else {
		    var js = JSON.parse(xhr.response);
			  var err = js["response"];
			  alert (err);
		}
	}
}