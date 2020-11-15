function handleCreateComment() {  
  var xhr = new XMLHttpRequest();
	var requestData = {};
	requestData["commentId"] = makeid(8);
	requestData["commentText"] = document.getElementById("comment").value;
	var today = new Date(); 
    requestData["commentDate"] = today.toISOString();
	requestData["regionStart"] = 0;
	requestData["regionEnd"] = 1;
	requestData["snippetId"] = document.getElementById("id-textarea").value;
	
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
		
		commentList.appendChild(snippetBtn);
	}
}

// Dynamically load list of comments
function loadComments(snippetId) {
	var xhr = new XMLHttpRequest();
	
	// send POST to get list of all comments
	xhr.open("GET", view_comment_url + snippetId);
	
	// send request
	xhr.send();
	
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