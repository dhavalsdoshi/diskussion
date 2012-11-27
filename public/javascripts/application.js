$(document).ready(function(){
    $('#create').click(function(evt) {
        var name = $("#nameBox").val();
        var comment = $("#commentBox").val();
        var dataString = 'name='+ name + '&comment=' + comment;
        console.log(dataString);
        $.ajax({
            type : 'POST',
            url : "/comment",
            data : dataString,
            success : function(data) {
                var html = "<li><label>User: </label>"+name +"<label> Comment: </label>"+comment+"</li>"
                $("#comments").append(html)
            }
        });
    });
});