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

function updateSnippetList(resp){
	var i;
	var snippetList = document.getElementById('snippetList');
	
	//clear snippetList
	snippetList.innerHTML = '';
	
	var jsonArray = JSON.parse(resp).list;
	
	for (i in jsonArray) {
		var snippetId = jsonArray[i].snippetId;
	
		// Button for snippet
		var snippetBtn = document.createElement("BUTTON");
		var t = document.createTextNode(snippetId);
		
		snippetBtn.setAttribute("style","color:red;font-size:23px");
		snippetBtn.appendChild(t);
		
		snippetList.appendChild(snippetBtn);
	}
} 