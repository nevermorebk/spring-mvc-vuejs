
var url = "/get-message";

$.ajax({
    async: true,
    url: url,
    method: "GET",
    contentType: "application/json; charset=utf-8",
    dataType: "json"
}).done(function (data) {
    console.log(data);
    build();
}).fail(function () {
    console.log("---> error")
}).always(function () {
    console.log("Complete Call Ajax: Search OTP!");
});

function build() {

    var div = $("#root");

    $.each(this.data, function (i, o) {
        div.append($('<div>', {"class": "alert alert-info"}).append($('<p>').append(o.title)))
    });
}
