$(function(){
	/**
	 * 设置输入框边框颜色
	 */
   $(".inputType").focus(function(){
		$(this).css("border","1px solid orange");
		
	});
   $(".code").focus(function(){
		$(this).css("border","1px solid orange");
		
	});
});
/**
 * 验证码切换
 */
function NextImage(){
		 var image=document.getElementById("image");
		 image.src=image.src+"?"+new Date().getTime();
}
