// Create a new snippet
$("#creator-new-snippet").click(function(e){
   if($("#info-textarea").val() == ""){
      $("#info-textarea").prop('disabled', false);
   }

   if($("#snippet-textarea").val() == ""){
      $("#snippet-textarea").prop('disabled', false);
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
			resp = [
		  		{ "id" : 1},
		  		{ "id" : 1 },
		  		{ "id" : 1 }
			];
			var i;
			for (i in resp) {
				var snippetId = resp[i].id;
			
				// Button for snippet
				var snippetBtn = document.createElement("BUTTON");
				var t = document.createTextNode(snippetId);
				
				snippetBtn.setAttribute("style","color:red;font-size:23px");
				snippetBtn.appendChild(t);
		
				var snippetList = document.getElementById('snippetList');
				snippetList.appendChild(snippetBtn);
			}
		}
	}
}

window.onload = function() {
  	loadSnippets();
}

function makeid(length) {
   var result           = '';
   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
   var charactersLength = characters.length;
   for ( var i = 0; i < length; i++ ) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
   }
   return result;
}

