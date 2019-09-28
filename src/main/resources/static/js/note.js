var qsParm = new Array();

$(document).ready(function () {
    var query = window.location.search.substring(1);
    var parms = query.split('&');
    for (var i = 0; i < parms.length; i++) {
        var pos = parms[i].indexOf('=');
        if (pos > 0) {
            var key = parms[i].substring(0, pos);
            var val = parms[i].substring(pos + 1);
            qsParm[key] = val;
        }
    }

    $.ajax({
        url: '/note/' + qsParm.id,
        type: 'get',
        success: function (data) {
            $("#title").val(data.title);
            $("#text").text(data.text);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
});

function myFunction() {
    if ($('#title').val() !== "" && $('#text').val() !== "") {

        var formData = {
            id : qsParm.id,
            title : $("#title").val(),
            text :  $("#text").val()
        };

        $.ajax({
            url: '/note/save',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data : JSON.stringify(formData),
            success: function (data) {
                window.location = 'index.html';
            },
            error: function (xhr, str) {
                alert('Возникла ошибка: ' + xhr.responseCode);
            }
        });
    }
}