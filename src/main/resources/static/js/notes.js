$(document).ready(function () {
    load();
});

function edit(Element) {
    window.location = 'note.html?id=' + Element.id;
}

function load() {
    $.ajax({
        url: '/notes/',
        type: 'get',
        success: function (data) {
            var table_body = '<table border="1">';
            table_body += '<thead>';
            table_body += '<tr>';
            table_body += '<td>';
            table_body += 'Title';
            table_body += '</td>';
            table_body += '<td>';
            table_body += 'Text';
            table_body += '</td>';
            table_body += '<td>';
            table_body += 'Date';
            table_body += '</td>';
            table_body += '<td>';
            table_body += '';
            table_body += '</td>';
            table_body += '<td>';
            table_body += '';
            table_body += '</td>';
            table_body += '</tr>';
            table_body += '</thead>';

            for (var i = 0; i < data.length; i++) {
                table_body += '<tr>';
                table_body += '<td>';
                table_body += data[i].title;
                table_body += '</td>';
                table_body += '<td>';
                table_body += data[i].date;
                table_body += '</td>';
                table_body += '<td><textarea name="" id="" cols="45" rows="10">';
                table_body += data[i].text;
                table_body += '</textarea></td>';
                table_body += '<td>';
                table_body += '<a href="#" id=' + data[i].id + ' onclick="return edit(this);">edit</a>';
                table_body += '</td>';
                table_body += '<td>';
                table_body += '<a href="#" id=' + data[i].id + ' onclick="return deleteNote(this);">delete</a>';
                table_body += '</td>';
                table_body += '</tr>';
            }

            table_body += '</table>';
            $('#tableDiv').html(table_body);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
}

function add() {
    window.location = 'note.html';
}

function deleteNote(Element) {
    if (confirm('Are you sure ?')) {
        $.ajax({
            url: '/note/delete/' + Element.id,
            type: 'DELETE',
            success: function (data) {
                load();
            },
            error: function (xhr, str) {
                alert('Возникла ошибка: ' + xhr.responseCode);
            }
        });
    }
}