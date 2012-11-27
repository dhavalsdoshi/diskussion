$(document).ready(function(){

    $('#create').click(function(evt) {
        var dataString = 'name='+ $("#nameBox").val() + '&comment=' + $("#commentBox").val();
        console.log(dataString);
        $.ajax({
            type : 'POST',
            url : "/comment",
            data : dataString,
            success : function(data) {
                console.log("Success");
            }
        });
    });


});