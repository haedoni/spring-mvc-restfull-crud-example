var productContainer = document.getElementById("row");

var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', 'http://localhost:8080/book');
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.responseText);
    renderHTML(ourData);    
};
ourRequest.onload = function(){
    console.log(ourRequest.responseText);
};

ourRequest.send();


function renderHTML(data){
    var htmlString = "";

    for(i=0; i<data.length; i++){
        htmlString += "<div class=\"col-lg-4\">" + data[i].imageLink
                        + "<h2>" + data[i].name + "</h2>"
                        + "<p>" + data[i].price + "</p>";
    }
    productContainer.insertAdjacentHTML('beforeend', htmlString);
}