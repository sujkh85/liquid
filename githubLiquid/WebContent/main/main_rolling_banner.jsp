<!--  
/***********************************************************************
 * 작업자 : 최승환
 * 작업일자 : 2014.12.10~11
 * 어떤 파일을 호출하는가 :
 * 파일 타입 : Main.jsp 에서 부품
 * 최승환 : hot item 밑에  이미지 롤링배너 보여줌 상품이미지에 있는 상품도 있고 pighip에서 이미지 그냥 가져옴
 ***********************************************************************/-->
 <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>rolling banner</title>
<!-- bestseller benner 스타일시트 or 스크립트 배너  -->
<style type="text/css">
.bestseller-div{width:358px; height:133px; overflow:hidden; position:relative; }
.bestseller-div a{display:inline-block; float:left; padding-right:10px; position:absolute;}
.bestseller-div img{border:0; width:100px; }
</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
//변수 선언
var lng = 0;
var total_width = 0;
var first_position = 0;
var keep_roll;
//기본 스피드 15 - 숫자가 커질수록 롤링 속도가 느려짐
var basic_speed = 15;

$( document ).ready(function() {
	//길이값 받아오기
	lng = $("#rollings").children("a").length;

	//총 width값 
	total_width = lng * 110;

	//처음 포지션 선택
	first_position = 330 - total_width;

	//유동 포지션
	var flex_position = first_position;

	for(var i=0; i<lng; i++)
	{
		//console.log(flex_position);
		$("#rollings").children("a").eq(i).css("left", flex_position + "px");
		flex_position = flex_position + 110;
	}
	
	keep_roll = setTimeout("bestseller_roll()", basic_speed);
});

	function bestseller_roll()
	{
		for(var i=0; i<lng; i++)
		{
			//현재 위치
			var current_left = $("#rollings").children("a").eq(i).css("left");
			
			$("#rollings").children("a").eq(i).css("left", (parseInt(current_left) + 1) + "px");

			if(parseInt(current_left) + 1 >= 347){
				$("#rollings").children("a").eq(i).css("left", first_position + "px");
			}
			//console.log(current_left);
		}
		//console.log("asd");
		//clearTimeout(keep_roll);
		keep_roll = setTimeout("bestseller_roll()", basic_speed);
	}

	function bestseller_stop(){
		clearTimeout(keep_roll);
	}
</script>
<!-- best seller 스타일시트 겸 스크립트 끝 -->


<!--rolling banner 스크립트 시작 -->
<style type="text/css">
* {
    margin:0;
    padding:0;
}
.visual {
    overflow:hidden;
    position:relative;
    margin:0 0 0 20px;
}
.visual ul li {
    display:inline
        
}
.visual ul li span {
    position:absolute;
    z-index:0;
    overflow:hidden;
}
.visual ul li a {
    width:13px;
    height:14px;
    position:absolute;
    bottom:32px;
    z-index:1;
    overflow:hidden;
    background:url(http://demoon84.cafe24.com/Demo/imgRolling/images/btn_visual_off.png) 0 0 no-repeat;
    text-indent:-99em
}
.visual ul li a.on {
    background:url(http://demoon84.cafe24.com/Demo/imgRolling/images/btn_visual_on.png) 0 0 no-repeat
}
.controler {
    position:absolute;
    z-index:9;
    bottom:27px;
}
.visual button {
    border:none;
    width:22px;
    height:20px;
    overflow:hidden;
    text-indent:-99em;
    color:#fff;
    cursor:pointer;
    float:left;
    margin-right:2px
}
.visual .btn_stop {
    background:url(http://demoon84.cafe24.com/Demo/imgRolling/images/btn_visual_stop.gif) no-repeat 0 0
}
.visual .btn_play {
    background:url(http://demoon84.cafe24.com/Demo/imgRolling/images/btn_visual_play.gif) no-repeat 0 0
}
</style>
<script type="text/javascript">
 $.fn.extend({
    rolImg: function (option) {
        option = option || {};
        var showImg = option.showImg - 1 || 0;
        var imgWidth = option.width || 100;
        var imgHeight = option.height || 100;
        var speed = option.speed || 3000;
        var autoSet = option.autoSet || 0;
        var controler = option.controler || 0;

        var varSet = {
            thisName: $(this),
            thisLiName: $(this).find("ul li"),
            liNum: $(this).find("ul li").size(), //number of banner
            cShowName: showImg
        };

        //loading
        lodingSet(showImg);

        //auto play
        if (autoSet > 0) {
            $(this).find(".btn_play").addClass("play");
            playImg = setInterval(autoPlay, speed);
        } else {
            $(this).find(".btn_stop").addClass("stop");
        }

        //stop play
        varSet.thisLiName.find("a").hover(

        function () {
            if (autoSet > 0) {
                clearInterval(playImg);
            }
        },

        function () {
            if (autoSet > 0) {
                playImg = setInterval(autoPlay, speed);
            }
        });

        varSet.thisName.find(".btn_stop").on("click", function () {
            if (!$(this).hasClass("stop")) {
                clearInterval(playImg);
                $(".play").removeClass("play");
                $(this).addClass("stop");
                autoSet = 0 ;
            }
        });

        varSet.thisName.find(".btn_play").on("click", function () {
            if (!$(this).hasClass("play")) {
                $(".stop").removeClass("stop");
                $(this).addClass("play");
                playImg = setInterval(autoPlay, speed);
                autoSet = 1 ;
            }
        });

        //btn click
        varSet.thisLiName.find("a").on("click", function () {
            var target = $(this);
            btnClickOne(target);
            return false;
        });

        //loading event
        function lodingSet(showImg) {

            //make button
            varSet.thisLiName.each(function (index) {
                var idName = "rolBanner" + (index + 1);
                $(this).prepend('<a href="#' + idName + '">' +'</a>');
                $(this).find("img").attr("id", idName);
            });

            // make img span wrap

            varSet.thisLiName.each(function () {
                $(this).find("img").wrap("<span></span>");
            });

            //make Controler
            if (controler > 0) {
                var txt = '<div class="controler">';
                txt += ' <button type="button" class="btn_stop">Auto play stop</button>';
                txt += ' <button type="button" class="btn_play">Auto play</button>';
                txt += ' </div>';

                varSet.thisName.prepend(txt);
            }

            //first button on
            varSet.thisLiName.eq(showImg).find("a").addClass("on");

            //button position	
            varSet.thisLiName.find("a").each(function (index) {
                var a = varSet.liNum * 20;
                var b = ((index + 1) * 20) - 20;
                var c = imgWidth / 2 - a;
                var e = (c + (b));

                $(this).next().css({
                    "display": "block"
                });

                $(this).css({
                    "left": "50%",
                        "margin-left": e
                });

                //first show img
                if ($(this).hasClass("on")) {
                    $(this).parent().siblings().find("img").hide();
                    $(this).next().show();
                }
            });

            // controler position
            var controlerPst = varSet.liNum * 20 + 60;
            controlerPst = imgWidth - controlerPst;
            $(".controler").css({
                "margin-left": controlerPst
            });

            //img size set
            varSet.thisName.css({
                "width": imgWidth,
                    "height": imgHeight
            });
            varSet.thisLiName.each(function (index) {
                $(this).css({
                    "width": imgWidth,
                        "height": imgHeight
                });
                $(this).find("img").css({
                    "width": imgWidth,
                        "height": imgHeight
                });
            });
        }

        //auto play
        function autoPlay() {
            varSet.thisLiName.each(function (index) {
                if ($(this).find("a").hasClass("on")) {
                    varSet.cShowName = index;
                }
            });

            if (varSet.cShowName < varSet.liNum - 1) {
                varSet.thisLiName.find("a").removeClass("on");
                varSet.thisLiName.eq(varSet.cShowName + 1).find("a").addClass("on");
            }

            if (varSet.cShowName >= varSet.liNum - 1) {
                varSet.thisLiName.find("a").removeClass("on");
                varSet.thisLiName.eq(0).find("a").addClass("on");
            }
            showCImgOne();
        }

        //view type
        function showCImgOne() {
            varSet.thisLiName.find("a").each(function (index) {
                if ($(this).hasClass("on")) {
                    $(this).parent().siblings().find("img").fadeOut();
                    $(this).next().find("img").fadeIn();
                }
            });
        }

        //button click event
        function btnClickOne(target) {
            //img show
            $(target).parent().siblings().find("img").fadeOut();
            $(target).next().find("img").fadeIn();

            //btn on
            $(target).parent().siblings().find("a").removeClass("on");
            $(target).addClass("on");
        }
    }
});

$(document).ready(function () {
    $(".visual").rolImg({
        showImg: 1, // first show images  (default: 1 / max: img number)
        width: 450, // img width         
        height: 300, // img height        
        speed: 2500, // rolling speed     (default: 3000) 1000 = 1초
        autoSet: 1, // autoplay           (default: 0 / auto:1)
        controler: 1 // Controler         (default: 0 / show:1)
    });
});
</script>
<!--rolling banner 스크립트 끝 -->
</head>
<body>
<TABLE>
<tr> 
<td>
<!--rolling banner Ul시작  -->
<div class="visual">
    <ul>
        <li><img src="./img/new11.jpg" alt="사진" /></li>
        <li><img src="./img/new12.jpg" alt="사진" /></li>
        <li><img src="./img/new13.jpg" alt="사진" /></li>
        <li><img src="./img/new14.jpg" alt="사진" /></li>
    </ul>
</div> 
<!--rolling banner Ul 끝 4장짜리 배너   -->

<!-- best seller 시작 -->
<!------------ 메인 베스트셀러 변경 시작 ------------->
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="bottom">
<DIV style="BORDER-BOTTOM: #000000 0px solid; POSITION: relative; BORDER-LEFT: #000000 0px solid; WIDTH: 358px; HEIGHT: 133px; BORDER-TOP: #000000 0px solid; BORDER-RIGHT: #000000 0px solid">
	<div class="bestseller-div" id="rollings" onmouseover="bestseller_stop();" onmouseout="bestseller_roll()">
		<!-- 상품1 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0210010003293.jpg?1416896643  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품2 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0330030003663.jpg?1415774820  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품3 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0160000001373.jpg?1417150841  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품4 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0070000009413.jpg?1416816789      "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품5 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0050000008993.jpg?1410936661     "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품6 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0210010003023.jpg?1415685261  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품7 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0180000003053.jpg?1416547688     "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품8 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0160000001353.jpg?1417402635   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품9 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0070000009353.jpg?1416208631  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품10 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0140010001753.jpg?1416295379  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품11 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0340020005923.jpg?1415777458 "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품12 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0330030003773.jpg?1417163664"  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품13 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0110000006793.jpg?1416201051  "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품14 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0050000009123.jpg?1414051170   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품15 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0180000003043.jpg?1416550762   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품16 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0210010003333.jpg?1417416686   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품17 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0110000006863.jpg?1416983268   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
		<!-- 상품18 시작 -->
		<A href="#">
			<img src="http://www.pighip.co.kr/shopimages/pighip/0210010003023.jpg?1415685261   "  onMouseOver="this.style.filter = 'alpha(opacity=50)';" onMouseOut="this.style.filter='none';">
		</A>
	</div>
</DIV>
</TD>
  </tr>
  </TABLE>
<!-- best seller 끝 -->
       
</body>
</html>