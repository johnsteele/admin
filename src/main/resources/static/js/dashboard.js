function clearMessages()
{
    // We need to send an ajax call to the server to clear all the messages for this user
    var maxMessageId = $(".maxMessageId").val();
    $.post( '/clearMessages/' + maxMessageId );

    var messagesBlock = $("#messagesList");
    $("#messagesList").html('');
    $("#messagesBadge").empty();
}