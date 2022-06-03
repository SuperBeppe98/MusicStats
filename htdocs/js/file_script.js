//Chart.html + File.html initialization
function getReady() {
    $(document).ready(function () {
        $(".button-collapse").sideNav();
        $('.tooltipped').tooltip();
        $('.tabs').tabs();
    });
}

//File.html
function getCollection() {
    var myObj, i, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/midi/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            txt += "<br><ul class='collection'>";
            if (Object.keys(myObj).length == 0) {
                txt += " <li class='collection-item'><div class='center'>No Files uploaded<a href='#!' class='secondary-content'></a></div></li>";
            } else {
                for (i in myObj) {
                    txt += " <li class='collection-item'><div>" +
                        myObj[i].name +
                        "<a href='#!' class='secondary-content'><i class='material-icons color-blue' onclick=" + "deleteButton('" + myObj[i].name + "')>delete</i></a></div></li>";
                }
            }
            txt += "</ul>";
            document.getElementById("upload-collection").innerHTML = txt;
        }
    }
}
function deleteButton(text) {
    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8081/midi/" + text;
    xmlhttp.open("DELETE", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.send();
    setTimeout(function () { getCollection() }, 1500);
}
function sendFile() {
    var data = new FormData();
    $.each(jQuery("#file")[0].files,
        function (i, file) {
            data.append("files", file);
        });
    var response = $.ajax({
        url: 'http://localhost:8081/file',
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        method: 'POST',
        async: false
    }).responseText;
    document.getElementById("collection").style.display = "block";
    if (response == "OK") {
        document.getElementById("collection_item_ok").style.display = "block";
        setTimeout(function () {
            document.getElementById("collection_item_ok").style.display = "none";
            document.getElementById("collection").style.display = "none";
        }, 5000);
    }
    if (response == "The file is already saved") {
        document.getElementById("collection_item_saved").style.display = "block";
        setTimeout(function () {
            document.getElementById("collection_item_saved").style.display = "none";
            document.getElementById("collection").style.display = "none";
        }, 5000);
    }
    if (response == "Incorrect extension of the file") {
        document.getElementById("collection_item_extension").style.display = "block";
        setTimeout(function () {
            document.getElementById("collection_item_extension").style.display = "none";
            document.getElementById("collection").style.display = "none";
        }, 5000);
    }
}