<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/book_list.css" />
<script type="text/javascript"  src="js/jquery.min.js"></script>
<script type="text/javascript">
   /** 等页面加载完成 绑定点击事件  */
   $(function(){
	   $("#filter li").bind('click',function(){
		   // 定义参数相关的变量 
		   var  category_id = $("#curr_cid").val();
		   var  orderStd = $(this).attr("name");
		   var  orderType = null;
		   var  pageSize = 4;
		   var  pageNumber = 1;
		   // 先获取原来的  class  属性值   
		   var  classStr = $(this).attr("class");
		   // 判断之前是 down  还是  up  如果之前是 down  则改成up 
		   if(classStr.indexOf("down") != -1){
			   classStr = classStr.replace("down","up");
			   orderType = "asc";
		   }else if(classStr.indexOf("up") != -1){
			   classStr = classStr.replace("up","down");
			   orderType = "desc";
		   }else{
			   classStr += " down ";
			   orderType = "desc";
		   }
		   // 发起ajax 请求 
		   $.ajax({
			   url:"productListAJAX.do",
			   type:"post",
			   success:function(datas){
				   var  $product_list = $(".product_list"); 
				   $product_list.empty();
				   // 根据返回的数据拼接页面 
				   for(var i=0;i<datas.length;i++){
					   var obj = datas[i];
					   var  divStr = 
						'<div class="pro_item">'
			            	+'<div class="pro_picture"><a href="ipad.html">'
			            	+'<img src="'+obj.picture+'" /></a></div>'
			            	+'<div class="pro_info">'
			            	+'<div class="pro_up">'
			            	+'<div class="bookName"><a href="#">'+obj.name+'</a></div>'
			            	+'<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：'
			            	+'<span>'+obj.author+'</span> 著，译<br />出&nbsp;版&nbsp;社：'
			            	+'<span>'+obj.publishing+'</span><br /></div>'
			            	+'</div>'
			            	+'<div class="pro_down">'
			            	+'<div class="pro_left">'
			            	+'出版时间：'+obj.publish_time+'<br />'
			            	+'定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥'+obj.fixed_price+'</s>'
			            	+'</div>'
			            	+'<div class="pro_right">'
			            	+'顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />'
			            	+'销量：<b><font>'+obj.print_number+'</font></b><span class="user_price"></span>'
			            	+'京东价：<b>￥$'+obj.lower_price+'</b>（43折)'
			                        +'</div>'
			                        +'</div>'
			                        +'<div class="clear"></div>'
			                        +'<div class="book_btn">'
			                        +'<a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />'
			                        +'</div>'
			                        +'</div>'            
			                        +'</div> '; 
					   $product_list.append($(divStr));       
				   }
			   },
			   dataType:"json",
			   data:{"category_id":category_id,"orderStd":orderStd,
				   "orderType":orderType,
				   "pageSize":pageSize,"pageNumber":pageNumber}
		   });
		   
		   $(this).attr("class",classStr);
		   //  点击谁 让其它的不选中 点击的对象选中
		   $("#filter li:not(this)").removeAttr("id");
		   $(this).attr("id","filter-curr");
	   });
   });
</script>
</head>
<body id="book">
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<!--位置-->
<div id="position" class="page_width">
	<ul>
     	<li><a href="#">首页</a></li>
        <li>&gt;</li>
     	<li><a href = "#">图书</a></li>
        <li>&gt;</li>
     	<li><a href="#">${curr_name}</a></li>
        <li>&gt;</li>
     	<li><a href="#">${curr_category.name}</a></li>
     </ul>
</div>
<!--主体main部分开始-->
<div class="clear"></div>

<div id="main" class="page_width">
<!--左侧开始-->
	<div id="left_list">
    	<div id="same_sort">
			<div class="book_tit" style="width:209px;"><h2>浏览同级分类<br /><span>Browse other categories</span></h2></div>
				<div class="book_content">
					<ul>
                        <c:forEach items="${categories }"  var="category">
                        <li><a href='bookList.do?parent_id=${category.parent_id}&current_category_id=${category.category_id}'>${category.name}</a></li>
                        </c:forEach>
					</ul>
                    <div class="clear"></div>
					<div class="extra"><a href="#">返回上级分类&gt;&gt;</a></div>
				</div>
			</div>	
			
            <div class="books">
			<div class="book_title">
				<h2>新书推荐<br /><span>New Releases</span></h2>
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			</div>
            
		
			<div class="ad_left_list">
            	<div class=""><a href="#" target="_blank"><img src="img/book_61.jpg" /></a></div>
				<div class=""><a href="#" target="_blank"><img src="img/book_47.jpg"></a></div>
			</div>

    </div>
<!--左侧结束-->

<!--右侧开始-->    
    <div id="right_list">
        <input   type="hidden" value="${curr_category.category_id}" id="curr_cid"/>
		<div id="filter">
			<div class="fore item">排序：</div>
			<ul class="item tab">
                <li id='filter-curr' class='down' name="print_number"><b></b><a href='#'>销售排行</a><span></span></li>
                <li  name="lower_price" class='down price'><b></b><a href="#">价格</a><span></span></li>
                <li  class="up discount"><b></b><a href='#'>折扣</a><span></span></li>
                <li class="down"><b></b><a href='#'>好评度</a><span></span></li>
                <li  class='down'><b></b><a href='#'>上架时间</a><span></span></li>
                <li  class="down"><b></b><a href='#'>出版时间</a><span></span></li>
			</ul>
			<span class="clear"></span>
		</div>
        
        <div class="page">
			<img src="images/page.jpeg" />
		</div>
        
        <div class="clear"></div>
        
        <div class="product_list">
        	<c:forEach items="${products}"  var="product">         
            <div class="pro_item">
            	<div class="pro_picture"><a href="ipad.html">
            	<img src="${product.picture}" /></a></div>
                <div class="pro_info">
                	<div class="pro_up">
                    	<div class="bookName"><a href="#">${product.name }</a></div>
                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：
                    	<span>${product.author }</span> 著，译<br />出&nbsp;版&nbsp;社：
                    	<span>${product.publishing}</span><br /></div>
                    </div>
                    <div class="pro_down">
                    	<div class="pro_left">
                    	出版时间：${product.publish_time}<br />
                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥${product.fixed_price }</s>
                        </div>
                        <div class="pro_right">
                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />
                        销量：<b><font>${product.print_number }</font></b><span class="user_price"></span>
                            京东价：<b>￥${product.lower_price}</b>（43折)
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="book_btn">
                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />
                    </div>
                </div>            
            </div> 
            </c:forEach>  
        </div><!--列表结束-->
        
        <div class="page">
			<img src="images/page.jpeg" />
		</div>
          
    </div>
<!--右侧结束-->
</div>

<div class="clear"></div>
<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
