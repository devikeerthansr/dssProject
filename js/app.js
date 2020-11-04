// Create a new snippet
$("#creator-new-snippet").click(function(e){
   if($("#info-textarea").val() == ""){
      $("#info-textarea").prop('disabled', false);
   }

   if($("#snippet-textarea").val() == ""){
      $("#snippet-textarea").prop('disabled', false);
   }
   
   if($("#id-textarea").val() == ""){
      $("#id-textarea").prop('disabled', false);
   }
});

// Add comment
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
      $("#info-textarea").prop('disabled', true);
   }
});

// Save ID
$("#save-id").click(function(e){
   if(!$("#id-textarea").val() == ""){
      $("#id-textarea").prop('disabled', true);
   }
});

// Save snippet
$("#save-snippet").click(function(e){
   if(!$("#snippet-textarea").val() == ""){
      $("#snippet-textarea").prop('disabled', true);
   }
});

// Edit info
$("#edit-info").click(function(e){
   $("#info-textarea").prop('disabled', false);
});

// Edit ID
$("#edit-id").click(function(e){
   $("#id-textarea").prop('disabled', false);
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

// Dynamically load list of snippets
function updateSnippetText() {
	var xhr = new XMLHttpRequest();
	
	var requestData = {};
	requestData["id"] = "?";
	requestData["text"] = document.getElementById("snippet-textarea").value;
	requestData["password"] = "?"; //ip address 
	requestData["codingLanguage"] = "?";
	
	// send POST to get list of all snippets
	xhr.open("POST", update_snippet_text_url, true);
	
	// send request
	xhr.send(JSON.stringify(requestData));
	
	// this will be called once response is received
	xhr.onloadend = function() {
		if (xhr.readyState == XMLHttpRequest.DONE)
		{
			if(xhr.status == 200)
			{
				document.getElementById("snippet-textarea").value = "GOOD";
			}
		}
		else
		{
			document.getElementById("snippet-textarea").value = "BAD";
		}
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
			var i;
			var snippetList = document.getElementById('snippetList');
			
			//clear snippetList
			snippetList.innerHTML = '';
			
			for (i in resp) {
				var snippetId = resp[i].id;
			
				// Button for snippet
				var snippetBtn = document.createElement("BUTTON");
				var t = document.createTextNode(snippetId);
				
				snippetBtn.setAttribute("style","color:red;font-size:23px");
				snippetBtn.appendChild(t);
				
				snippetList.appendChild(snippetBtn);
			}
		}
	}
}

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

window.onload = function() {
  	loadSnippets();
}



