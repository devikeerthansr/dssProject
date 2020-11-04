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
  var data = {};
  data["snippetId"] = makeid(8);
  data["snippetText"] = document.getElementById("snippet-textarea").value;
  data["snippetInfo"] = document.getElementById("info-textarea").value;
  
  data["snippetPassword"] = "10.23.46.235";
  data["codingLanguage"] = document.getElementById("languages").value;
  data["numComments"] = 0;
  var today = new Date();
  
      var min = today.getTime() / 1000 / 60; // 
        var localNow = new Date().getTimezoneOffset(); // get the timezone
        // offset in minutes
        var localTime = min - localNow; // get the local time

    var dateStr = new Date(today * 1000 * 60);
    dateStr = dateStr.toString("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
     
  data["createDate"] = "2020-11-04T04:29:26.896Z";
  
  var js = JSON.stringify(data);
  console.log("JS:" + js);
  var xhr = new XMLHttpRequest();
  xhr.open("POST", create_snippet_url, true);

  // send the collected data as JSON
  xhr.send(js);

  // This will process results and update HTML as appropriate. 
  xhr.onloadend = function () {
    console.log(xhr);
    console.log(xhr.request);
    if (xhr.readyState == XMLHttpRequest.DONE) {
    	 if (xhr.status == 200) {	      
	      updateSnippetList(xhr.response);
    	 } else {
    		  var js = JSON.parse(xhr.response);
			  var err = js["response"];
			  alert (err);
    	 }
    } else {
      
    }
  };
}