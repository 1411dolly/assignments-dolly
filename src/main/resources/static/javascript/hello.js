$(document).ready(function () {
    click();
    console.log("here");
});

function click() {
    $("#button").click(function () {
        alert("button clicked!!!");
    })
};