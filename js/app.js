// Create a new snippet
$("#creator-new-snippet").click(function(e){
   
      $("#info-textarea").prop('disabled', false);  
      $("#snippet-textarea").prop('disabled', false);      
   
});

// Add Comment
$("#add-comment").click(function(e){
   if($("#comment").val() == ""){
      $("#comment").prop('disabled', false);
   }
});

// Save comment
$("#save-comment").click(function(e){
   if(!$("#comment").val() == ""){
      $("#comment").prop('disabled', true);
   }
});

// Delete comment
$("#delete-comment").click(function(e){
   $("#comment").val("");
});


// Save info 
$("#save-info").click(function(e){
   if(!$("#info-textarea").val() == ""){
	   updateSnippetInfo();
      $("#info-textarea").prop('disabled', true);
   }
});

// Save snippet
$("#save-snippet").click(function(e){
   if(!$("#snippet-textarea").val() == ""){
	   handleCreateClick();
	   updateSnippetText();
      $("#snippet-textarea").prop('disabled', true);
   } 
});

// Edit info
$("#edit-info").click(function(e){
   $("#info-textarea").prop('disabled', false);
});

// Edit snippet
$("#edit-snippet").click(function(e){
   $("#snippet-textarea").prop('disabled', false);
});

// Delete snippet
$("#delete-snippet").click(function(e){
   $("#snippet-textarea").val("");
   $("#info-textarea").val("");
   $("#id-textarea").val("");
});

// Update Snippet Text
function updateSnippetText() {
	var xhr = new XMLHttpRequest();
	
    $.get("https://ipinfo.io", function(response) { 
		var requestData = {};
		requestData["id"] = document.getElementById("id-textarea").value;
		requestData["text"] = document.getElementById("snippet-textarea").value;
		requestData["password"] = response.ip;
		requestData["codingLanguage"] = document.getElementById("languages").value;

		var js = JSON.stringify(requestData);
		console.log("JS:" + js);

		xhr.open("POST", update_snippet_text_url, true);

		// Send the collected data as JSON
		xhr.send(js);
	}, "json")

	xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
		if (xhr.status == 200) 
		{
			console.log ("XHR:" + xhr.responseText);
			showAlert("Snippet is updated!");
    	} 
		else 
		{
			console.log("actual:" + xhr.responseText)
			var js = JSON.parse(xhr.responseText);
			var err = js["response"];
			alert (err);
		}
    }
  }
}

// Update Snippet Info
function updateSnippetInfo() {
	var xhr = new XMLHttpRequest();
	var requestData = {};
	requestData["id"] = document.getElementById("id-textarea").value;
	requestData["info"] = document.getElementById("info-textarea").value;
    
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);

	xhr.open("POST", update_snippet_info_url, true);

	// Send the collected data as JSON
	xhr.send(js);

	xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
		if (xhr.status == 200) 
		{
			console.log ("XHR:" + xhr.responseText);
			showAlert("Snippet info is updated!");
    	} 
		else 
		{
			console.log("actual:" + xhr.responseText)
			var js = JSON.parse(xhr.responseText);
			var err = js["response"];
			alert (err);
		}
    }
  }
}

function requestSnippet(snippetId)
{
	console.log(snippetId);
	
	var xhr = new XMLHttpRequest();
	
	// send POST to get list of all snippets
	xhr.open("GET", view_snippet_url + snippetId);
	
	// send request
	xhr.send();
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{
			var resp = xhr.response;
			
			//Update snippet text
			var snippetText = document.getElementById('snippet-textarea');
			snippetText.value = resp.text;
			
			//Update snippet info
			var snippetInfo = document.getElementById('info-textarea');
			snippetInfo.value = resp.info;
			
			var idArea = document.getElementById('id-textarea');
			idArea.value = resp.id;
		}
	}
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
		
		snippetBtn.onclick = function() { 
			requestSnippet(snippetId+'');
		};
		
		snippetList.appendChild(snippetBtn);
	}
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
		var snippetBtn = document.createElement("BUTTON");
		var t = document.createTextNode(commentText);
		
		snippetBtn.setAttribute("style","color:black;font-size:15px");
		snippetBtn.appendChild(t);
		
		snippetList.appendChild(snippetBtn);
	}
}
// Dynamically load list of snippets
function loadSnippets() {
	var xhr = new XMLHttpRequest();
	
	// send POST to get list of all snippets
	xhr.open("GET", list_url);
	
	// send request
	xhr.send();
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{
			var resp = xhr.response;
			updateSnippetList(resp);
		}
	}
}

window.onload = function() {
  	loadSnippets();
}

function showAlert(message) {
    alert(message);
}



