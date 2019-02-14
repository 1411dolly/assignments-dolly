$( document ).ready(function() {

    console.log("Hello World!");

    $("#button1").click(function () {
        $("#test").addClass("class1");
    });

    $("#button2").click(function () {
        $("div[class$='new']").css("color", "red");
    });

    $("#button3").click(function () {
        $("#button3").attr("disabled", true);
    });

    $("#button4").click(function () {
        $("#main").children(".target").css("font-size", "40px");
    });


    var p = $("div#page1").text();
    $("#page2").replaceWith(p);

    $(".clicks").click(function () {
        $(".parent").append("<button class='newclick'>Click Me</button>");

    });

    $(".parent").on('click', '.newclick', function () {
        $(".parent").append("<button class='newclick'>Click Me</button>");

    });


    $('#pick').change(function () {
        var val1 = $('#pick option:selected').val();
        $("#div1").append(val1);
    });

    $("#menu li").hover(function () {
        $(".dropdown-menu", this).slideDown(100);
    }, function () {
        $(".dropdown-menu", this).stop().slideUp(100);
    });

    var max = -1;
    $(".height").each(function () {
        var h = $(this).height();
        max = h > max ? h : max;
    });
    document.getElementById("maxheight").innerText = max;


    $("#google").click(function (e) {
        e.preventDefault();
    });


    $("#parentclick").click(function () {
        alert("hello dolly!!!");
    });

    $(".childclick").click(function () {
        $("#parentclick").prop("disabled", true);
        // $("#parentclick").attr("disabled","disabled");
    });

    $("#colorchange").click(function () {
        $("#qw tr").each(function () {
            var customerId = $(this).find(".num").html();
            if (customerId > 10)
                $(this).css("background-color", "aquamarine");
        });

    });

    var myvar;
    var dol;
    $("#dolly").click(function () {

        dol = $.ajax({
            url: "https://jsonplaceholder.typicode.com/posts",
            method: "GET"
        }).done(function (response) {
            $("#url").text(JSON.stringify(response));
            myvar = response;
            console.log(myvar);
        });


             $("#table").each(resp, function(i, item) {
                 var $tr = $('<tr>').append(
                     $('<td>').text(item.id),
                     $('<td>').text(item.title),
                     $('<td>').text(item.body)
                 );
                 console.log($tr.wrap('<p>').html());
         });

    });


    $("#animate").click(
        function () {
            var delay = 0;

            setInterval(function () {

                var image = ["1.jpeg", "2.jpeg", "3.jpeg", "4.jpeg", "5.jpeg"];


                $(".slider").attr('src', image[delay]);
                delay++;
                if (delay == 5) {

                    delay = 0;
                }
                console.log(image[delay]);


            }, 3000);
        });


});
