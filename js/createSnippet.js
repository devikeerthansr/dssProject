
function makeid(length) {
   var result           = '';
   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
   var charactersLength = characters.length;
   for ( var i = 0; i < length; i++ ) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
   }
   return result;
}

function handleCreateClick() {  
  var xhr = new XMLHttpRequest();
  
  $.get("https://ipinfo.io", function(response) { 
		  var data = {};
		  data["snippetId"] = makeid(8);
		  data["snippetText"] = document.getElementById("snippet-textarea").value;
		  data["snippetInfo"] = document.getElementById("info-textarea").value;
          data["snippetPassword"] = response.ip; 
          data["codingLanguage"] = document.getElementById("languages").value;
		  		  
		  $("#id-textarea").val(data["snippetId"]);
		  
		  var today = new Date(); 
		  data["createDate"] = today.toISOString();
		  
		  var js = JSON.stringify(data);
		  console.log("JS:" + js);

		  xhr.open("POST", create_snippet_url, true);
		
		  // send the collected data as JSON
		  xhr.send(js);
        }, "json")

  // This will process results and update HTML as appropriate. 
  xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
    	 if (xhr.status == 200) {	      
	      loadSnippets();
	      showAlert("New snippet is created!");
    	 } else {
    		  var js = JSON.parse(xhr.response);
			  var err = js["response"];
			  alert (err);
    	 }
    } else {
      
    }
  };
}