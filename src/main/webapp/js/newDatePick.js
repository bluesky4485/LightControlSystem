/**
 * Created by Leon.z on 2015-05-06. 时间选择插件
 */
(function($) {
	$.fn.newDatePick = function(options) {
		/**插件默认值**/
		$.fn.newDatePick.defaults = {
			titBg: "#2da5ec", //头部背景颜色
			borColor: "#2da5ec", //边框颜色
			btnColor: "#2da5ec", //按钮颜色
			isScroll:true,       //是否启用插件
			isTime:true,       //是否启用时间选择
			jsUrl:"js/jquery-rollValue.js" //滚动触发插件连接
		};
		var opt = $.extend({}, $.fn.newDatePick.defaults, options);
		return this.each(function() {
			var _ele = $(this),
				Hour, Minute, Second;
			_ele.val("");
			addCSS();
			_ele.on("click focus", function(e) {
				e.preventDefault();
				e.stopPropagation();
				if ($(".dateBar")[0]) {
					$(".dateBar").remove();
				}
				var ih = $(this).height(),
					iw = $(this).width(),
					PosY = $(this).offset().top + ih + 7,
					PosX = $(this).offset().left;
				renderPage(PosX, PosY, new Date());
			});

			function addCSS() {
				var link = document.createElement('link');
				link.type = 'text/css';
				link.rel = 'stylesheet';
				link.href = 'css/newDatePick.css';
				document.getElementsByTagName("head")[0].appendChild(link);
			};
			var renderPage = function renderPage(x, y, date) {
				var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours(),
					minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes(),
					second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
				var html = [
					'<div class="dateBar" id="test" style="border:1px solid ' + opt.borColor + ';position:absolute;left:' + x + 'px;top:' + y + 'px;z-index:99999">',
					'<h3 class="title" style="background:' + opt.titBg + '">时间选择器</h3>',
					'<span>年：<input type="number" class="myDate first" value="' + date.getFullYear() + '"/></span>',
					'<span>月：<input type="number" class="myDate" value="' + parseInt(date.getMonth() + 1) + '"/></span>',
					'<span>日：<input type="number" class="myDate" value="' + date.getDate() + '" minValue="1" /></span>',
					'<div class="bar">',
					'<div class="prbar">时：<div class="growbar" id="slider1"></div><strong class="preshow">' + hour + '</strong></div>',
					'<div class="prbar">分：<div class="growbar" id="slider2"></div><strong class="preshow">' + minute + '</strong></div>',
					'<div class="prbar">秒：<div class="growbar" id="slider3"></div><strong class="preshow">' + second + '</strong></div>',
					'</div>',
					'<p style="margin:10px 0 5px"><button class="btns now" style="background:' + opt.btnColor + '">当前</button> <button  class="btns sure" style="background:' + opt.btnColor + '"> 确定</button></p>',
					'</div>'
				].join("");

				if ($(".dateBar") && $(".dateBar").length === 0) {
					_ele.after(html);
					renderCss(date, doNext);
				} else if (!$(".dateBar").is(":visible")) {
					$(".dateBar").fadeIn(100)
				}

			};
			var renderCss = function renderCss(date, callback) {
				if ($(".dateBar").is(":visible")) {	
					if(opt.isTime){

						$("#slider1").slider({
							orientation: "horizontal",
							range: "min",
							max: 24,
							min: 0,
							value: date.getHours(),
							slide: function(event, ui) {
								var now = ui.value < 10 ? "0" + ui.value : ui.value;
								$(this).next().html(now);
								getValue();
							}
						});
						$("#slider2").slider({
							orientation: "horizontal",
							range: "min",
							max: 59,
							min: 0,
							value: date.getMinutes(),
							slide: function(event, ui) {
								var now = ui.value < 10 ? "0" + ui.value : ui.value;
								$(this).next().html(now);
								getValue();
							}
						});
						$("#slider3").slider({
							orientation: "horizontal",
							range: "min",
							max: 59,
							min: 0,
							value: date.getSeconds(),
							slide: function(event, ui) {
								var now = ui.value < 10 ? "0" + ui.value : ui.value;
								$(this).next().html(now);
								getValue();

							}
						});
					}else{
						$(".bar").hide();
					}				
					if (typeof(callback) === "function") {
						callback && callback();
					}
				};
			};
			var getValue = function getValue() {
				var year = $(".dateBar").find("input.myDate:first").val(),
					month = $(".dateBar").find("input.myDate:eq(1)").val() < 10 ? "0" + $(".dateBar").find("input.myDate:eq(1)").val() : $(".dateBar").find("input.myDate:eq(1)").val(),
					day = $(".dateBar").find("input.myDate:last").val() < 10 ? "0" + $(".dateBar").find("input.myDate:last").val() : $(".dateBar").find("input.myDate:last").val();
				Hour = parseInt($(".bar").find(".preshow:first").html()) < 10 ? "0" + parseInt($(".bar").find(".preshow:first").html()) : parseInt($(".bar").find(".preshow:first").html());
				Minute = parseInt($(".bar").find(".preshow:eq(1)").html()) < 10 ? "0" + parseInt($(".bar").find(".preshow:eq(1)").html()) : parseInt($(".bar").find(".preshow:eq(1)").html());
				Second = parseInt($(".bar").find(".preshow:last").html()) < 10 ? "0" + parseInt($(".bar").find(".preshow:last").html()) : parseInt($(".bar").find(".preshow:last").html());
				if(!opt.isTime){
					_ele.val(year + "-" + month + "-" + day);
				}else{
					_ele.val(year + "-" + month + "-" + day + " " + Hour + ":" + Minute + ":" + Second);
				}
				
			};

			var doNext = function doNext() {
				if ($(".dateBar").is(":visible")) {

					$(".dateBar").find(".sure").on("click", function(e) {
						e.preventDefault();
						e.stopPropagation();
						getValue();
						$(".dateBar").hide();
					});

					$(".dateBar").find(".now").on("click", function(e) {
						var date = new Date();
						$(".dateBar").find("input.myDate:first").val(date.getFullYear());
						$(".dateBar").find("input.myDate:eq(1)").val(date.getMonth() + 1);
						$(".dateBar").find("input.myDate:last").val(date.getDate());
						$("#slider1").slider({
							value: date.getHours()
						}) && $("#slider2").slider({
							value: date.getMinutes()
						}) && $("#slider3").slider({
							value: date.getSeconds()
						});
						$(".dateBar").find(".preshow:first").html(date.getHours() < 10 ? "0" + date.getHours() : date.getHours());
						$(".dateBar").find(".preshow:eq(1)").html(date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes());
						$(".dateBar").find(".preshow:last").html(date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds());
						getValue();

					});
					if(opt.isScroll && opt.jsUrl){
						jQuery.getScript(opt.jsUrl, function(data, textStatus) {
						  if(textStatus === "success"){
								$(".myDate").each(function(k) {
									$(this).on("click", function() {
										switch (k) {
											case 0:
												$(this).rollValue({
													minValue: 2000,
													maxValue: new Date().getFullYear() + 100,
													step: 1
												});
												break;
											case 1:
												$(this).rollValue({
													minValue: 1,
													maxValue: 12,
													step: 1
												});
												break;
											case 2:
												$(this).rollValue({
													minValue: 1,
													maxValue: 31,
													step: 1
												});
												break;
										}
									})
								})
						  }
						});
					};	
					$(document).on("click", function(e) {
						var e = e || window.event;
						var elem = e.target || e.srcElement;
						while (elem) {
							if (elem.className && elem.className == 'dateBar') {
								return;
							}
							elem = elem.parentNode;
						}
						$(".dateBar").remove();

					})
				}
			};
		});
	};
})(jQuery);