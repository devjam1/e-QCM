$(document).ready(function(){
    var timer;
        $('.navbar-brand').on({
            'mouseover': function () {
                timer = setTimeout(function () {
                    $(".navbar-brand i").toggleClass('fa-spin');
                }, 700);
            },
            'mouseout' : function () {
                clearTimeout(timer);
                $(".navbar-brand i").removeClass('fa-spin');
            }
        });
    
 });

