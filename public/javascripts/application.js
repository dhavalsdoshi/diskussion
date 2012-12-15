$(document).ready(function () {
    $('form').submit(function (evt) {
        var name = $("#usernameTextBox").val();
        var comment = $("#commentTextBox").val();
        var dataString = $('form').serialize();
        console.log(dataString);
        $.ajax({
            type:'POST',
            url:"/comment",
            data:dataString,
            success:function (data) {
                var html = "<li><label>User: </label>" + name + "<label> Comment: </label>" + comment + "</li>";
                $("#comments").append(html);
            }
        });
        evt.preventDefault();
    });
});