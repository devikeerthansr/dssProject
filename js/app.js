var snippetTextBeingEdited = false;

// Create a new snippet
$("#creator-new-snippet").click(function(e){
   	  $("#info-textarea").prop('disabled', false);  
      $("#snippet-textarea").prop('disabled', false);     
      $("#snippet-textarea").text("");
   			$("#info-textarea").val("");
   			$("#id-textarea").val("");
   			$("#comment").val("");
   			$("#view-comment-area").val("");
			if (document.getElementById('commentList') != null)
			{
			   document.getElementById('commentList').innerHTML = '';
			} 
   
});

// Refresh current snippet
$("#refresh-snippet").click(function(e){
   if(!$("#id-textarea").val() == ""){
      requestSnippet($("#id-textarea").val());
   }     
});

// Refresh Snippet List for Admin
$("#admin-refresh-snippet-list").click(function(e){
   loadSnippets();
});

// Add Comment
$("#add-comment").click(function(e){
      $("#comment").prop('disabled', false);
      $("#snippet-textarea").prop('disabled', false); 
      snippetTextBeingEdited == true;
});

// Save comment
$("#save-comment").click(function(e){
   if(!$("#comment").val() == ""){
      $("#comment").prop('disabled', true);
      $("#snippet-textarea").prop('disabled', true); 
      handleCreateComment();
   }
});

// Delete comment
$("#delete-comment").click(function(e){
   $("#view-comment-area").val("");
});

// refresh comments
$("#refresh-button-com").click(function(e){
	if(!$("#id-textarea").val() == ""){
   		loadComments(document.getElementById("id-textarea").value);
   	}
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
   if(!$("#snippet-textarea").text() == ""){
      if (snippetTextBeingEdited == true)
	  {
		updateSnippetText();
		snippetTextBeingEdited = false;
	  }
	  else
	  {
	    handleCreateClick();
	  }
      $("#info-textarea").prop('disabled', true);  
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
   snippetTextBeingEdited = true;
});

// Delete snippet
$("#delete-snippet").click(function(e){
	deleteSnippet();   
});

// Update Snippet Text
function updateSnippetText() {
	var xhr = new XMLHttpRequest();
	
    $.get("https://ipinfo.io", function(response) { 
		var requestData = {};
		requestData["snippetId"] = document.getElementById("id-textarea").value;
		requestData["snippetText"] = document.getElementById("snippet-textarea").innerText;
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

// delete Snippet 
function deleteSnippet() {
	var xhr = new XMLHttpRequest();
	
    $.get("https://ipinfo.io", function(response) { 
		var requestData = {};
		requestData["snippetId"] = document.getElementById("id-textarea").value;
		requestData["snippetPassword"] = response.ip;
		if(document.title == "Admin"){
		 requestData["isAdmin"] = true;
		} else {
		 requestData["isAdmin"] = false;
		}
		var js = JSON.stringify(requestData);
		console.log("JS:" + js);

		xhr.open("POST", delete_snippet_url, true);

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
			showAlert("Snippet is deleted!");
			$("#snippet-textarea").text("");
   			$("#info-textarea").val("");
   			$("#id-textarea").val("");
   			$("#comment").val("");
   			$("#view-comment-area").val("");
			if (document.getElementById('commentList') != null)
			{
			   document.getElementById('commentList').innerHTML = '';
			}
			updateSnippetList(xhr.response);
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
	requestData["snippetId"] = document.getElementById("id-textarea").value;
	requestData["snippetInfo"] = document.getElementById("info-textarea").value;
    
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
	var xhr = new XMLHttpRequest();
	
	var requestData = {};
	requestData["snippetId"] = snippetId;
	var js = JSON.stringify(requestData);
	console.log("JS:" + js);
    xhr.open("POST", view_snippet_url, true);
	// Send the collected data as JSON
	xhr.send(js);
	
	// this will be called once response is received
	xhr.onload = function() {
		if(xhr.status == 200)
		{
			var resp = JSON.parse(xhr.response).snippet;
			
			//Update snippet text
			var snippetText = document.getElementById('snippet-textarea');
			if (snippetText != null)
			{
			   snippetText.textContent = resp.snippetText;
			}
			
			//Update snippet info
			var snippetInfo = document.getElementById('info-textarea');
			snippetInfo.value = resp.snippetInfo;
			
			var idArea = document.getElementById('id-textarea');
			idArea.value = resp.snippetId;
			
			$.get("https://ipinfo.io", function(response) { 
	        	if(resp.snippetPassword != response.ip)
				{
					document.getElementById('delete-snippet').style.visibility = 'hidden';
				}			
				else 
				{
					document.getElementById('delete-snippet').style.visibility = 'visible';
				}
				
				if (document.getElementById('admin-container'))
			    {
					document.getElementById('delete-snippet').style.visibility = 'visible';
				}	
	        }, "json")
			$("#comment").val("");
			$("#view-comment-area").val("");
			showAlert("Requested snippet is loaded!");
			if (typeof loadComments !== 'undefined')
			{
				loadComments(snippetId)
			}
		}
	}
}

function updateSnippetList(resp){
	var i;
	var snippetList = document.getElementById('snippetList');
	
	//clear snippetList
	snippetList.innerHTML = '';
	
	var jsonArray = JSON.parse(resp).list;
	
	var createClickHandler = function(arg) {
  		return function() { requestSnippet(arg); };
	}
	
	for (i in jsonArray) {
		var snippetId = jsonArray[i].snippetId;
		var createDate = jsonArray[i].createDate;
	
		// Button for snippet
		var snippetBtn = document.createElement("BUTTON");
		var t = document.createTextNode(snippetId);
		var date = document.createTextNode(createDate);

		snippetBtn.setAttribute("style","color:red;font-size:23px");
		snippetBtn.appendChild(t);
		snippetBtn.appendChild( document.createTextNode('\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0'));
		snippetBtn.appendChild(date);
		
		snippetBtn.addEventListener('click',createClickHandler(snippetId));
		
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
