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
	        
	var selectedText = '';
  
	// window.getSelection 
	if (window.getSelection) { 
		selectedText = window.getSelection();
	}  
	
	var inputText = document.getElementById('snippet-textarea');
 	var innerText = inputText.textContent;
 	var textStartIdx = innerText.indexOf(selectedText.toString().trim());
 	var textLength = selectedText.toString().length;
	var textEndIdx = textStartIdx + textLength;

	requestData["regionStart"] = textStartIdx;
	requestData["regionEnd"] = textEndIdx;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);
	
	alert(js);

	xhr.open("POST", create_comment_url, true);

	// Send the collected data as JSON
	xhr.send(js);

  // This will process results and update HTML as appropriate. 
  xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
    	 if (xhr.status == 200) {
    	  highlight(textStartIdx, textEndIdx, requestData["commentId"]);
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
	var createCommentClickHandler = function(arg1,arg2) {
  		return function() { requestComment(arg1,arg2); };
	}
	for (i in jsonArray) {
		var commentText = jsonArray[i].commentText;
		var commentId = jsonArray[i].commentId;
		var snippetId = jsonArray[i].snippetId;
		var startIdx = jsonArray[i].regionStart;
		var endIdx = jsonArray[i].regionEnd;
			
		// Button for snippet
		var commentBtn = document.createElement("BUTTON");
		var t = document.createTextNode(commentText);
		
		commentBtn.setAttribute("style","color:black;font-size:15px");
		commentBtn.appendChild(t);
		commentBtn.addEventListener('click',createCommentClickHandler(snippetId,commentId));
		commentList.appendChild(commentBtn);
	}
}

function requestComment(snippetId,commentId)
{
	var xhr = new XMLHttpRequest();
	
	var requestData = {};
	requestData["snippetId"] = snippetId;
	requestData["commentId"] = commentId;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);
    xhr.open("POST", view_comment_url, true);
	// Send the collected data as JSON
	xhr.send(js);
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{
			var resp = JSON.parse(xhr.response).comment;
			
			//Update snippet text
			var commentText = document.getElementById('comment');
			commentText.value = resp.commentText+"\n Created on:"+resp.commentDate;	
			
			var deleteCommentClickHandler = function(arg1,arg2) {
  				return function() { deleteComment(arg1,arg2); };
			}
			
			// Button for delete comment
			var deleteBtn = document.getElementById('delete-comment');
			var delClone = deleteBtn.cloneNode(true);

			deleteBtn.parentNode.replaceChild(delClone, deleteBtn);
			
			delClone.addEventListener('click',deleteCommentClickHandler(snippetId,commentId));	
			
			highlight(resp.regionStart, resp.regionEnd, commentId);
							
			showAlert("Requested comment is loaded!");			
		}
	}
}

function highlight(textStartIdx, textEndIdx, commentId) 
{
  if(textStartIdx == textEndIdx)
  {
  	return;
  }

  var inputText = document.getElementById('snippet-textarea');
  var innerText = inputText.textContent;
  var innerHTML = inputText.innerHTML;

  if (textStartIdx >= 0) { 
   innerHTML = innerText.substring(0,textStartIdx) + "<span class='highlight' id =" + commentId + ">" + innerText.substring(textStartIdx,textEndIdx) + "</span>" + innerText.substring(textEndIdx);
   inputText.innerHTML = innerHTML;
  }
}

function deleteComment(snippetId,commentId)
{
	var xhr = new XMLHttpRequest();
	
	var requestData = {};
	requestData["commentId"] = commentId;
	requestData["snippetId"] = snippetId;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);
    xhr.open("POST", delete_comment_url, true);
	// Send the collected data as JSON
	xhr.send(js);
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{;
			var resp = xhr.response;
			alert(resp);
			updateCommentList(resp);
			
			commentText.value = "";	
			
			showAlert("Comment is deleted!");			
		}
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