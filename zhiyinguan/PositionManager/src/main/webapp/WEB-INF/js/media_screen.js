function adjustStyle(width) {
    width = parseInt(width);
    if (width < 902) {
//alert("<900");
//alert(width);
        $("#size-stylesheet").attr("href", "navigateLowerIE8.css");
    } else {
      // alert(">900");
  //alert(width);
       $("#size-stylesheet").attr("href", ""); 
    }
}

$(function() {
    adjustStyle($(this).width());
    $(window).resize(function() {
        adjustStyle($(this).width());
    });
});
