<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style type="text/css" media="screen">  
     .onmouset_out {  
       background-color: #000000;   
     }  
     .onmouset_over {   
       background-color: #006600;  
     }  
     #result_display {  
       border: 1px solid ##000000;
     }    
    </style>  
<script type="text/javascript">
	 var xmlHttp;   
      //创建XMLHttpRequest对象  
      function createXmlHttp() {  
      //根据window.XMLHttpRequest对象是否存在使用不同的创建方式  
	        try {
				return new XMLHttpRequest();
			} catch (e) {
			}try {
				return ActvieXObject("Msxm12.XMLHTTP");
			} catch (e) {
			}try {
				return ActvieXObject("Microsoft.XMLHTTP");
			} catch (e) {
				throw e;
			}
      }  
	function inputSuggest() {
		var keywords = document.getElementById("keyword").value;
		var xmlHttp = createXmlHttp();
		var url ="index?flag=searchkeyword&keywords="+keywords;
		xmlHttp.open("post",url,true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
		 if(xmlHttp.readyState==4 && xmlHttp.status==200){  
                var str = xmlHttp.responseText.split("#");  
                var s = document.getElementById("result_display")  
                s.innerHTML = '';  
               
                for(i=0; i < str.length - 1; i++) {  
                   var suggest = '<div onmouseover="onmouseOver(this);" ';  
                   suggest += 'onmouseout="onmousetOut(this);" ';  
                   suggest += 'onclick="setSuggestValue(this.innerHTML);" ';  
                   suggest += 'class="onmouset_out">' + str[i] + '</div>';  
                   s.innerHTML += suggest;  
                }  
             
         } 
		}
	}

	function onmouseOver(div) {
		div.className = 'onmouse_over';
	}
	function onmousetOut(div) {
		div.className = 'onmouset_out';
	}
	function setSuggestValue(value) {
		document.getElementById("keyword").value = value;
		document.getElementById("result_display").innerHTML = '';
	}
</script>
<form method="post" name="search" action="index?flag=search">
	搜索：
	<input class="input-text" type="text" name="keywords" id="keyword" onkeyup="inputSuggest();"/>
	<input class="input-btn" type="submit" name="submit" value="" />
	 <div id="result_display" style="width:200px  ;float: right">  </div>
</form>


