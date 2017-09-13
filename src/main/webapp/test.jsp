<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div id="UpdatePanel1">
                         <div class="catwHead">
                             <span class="catwTitle">我的提问</span>
                            （提交您的问题内容，我们的客户经理将及时与您取得联系）
                        </div>
                         <span class='catwTip'></span>
                         <form action="" enctype="multipart/form-data" method="post">
                             <div class="catwInput">
                                 <input name="comname" type="text" id="comname"  value='公司名称：' />
                                 <input name="tel" type="text" id="tel"   value='电话：'/>
                             </div>
                             <div class="catwInput">
                                 <input name="name" type="text" id="name"  value='姓名：' />
                                 <input name="email" type="text" id="email" value='邮箱：' />
                             </div>
                             <div class="catwText">
                                 <textarea name='mesinfo' id='mesinfo' value='内容：'></textarea>
                            </div>

                             <div id="catwBtn" class="catwBtn">
                                 <span class="catwSubmit">
                                 <input type="submit" name="submit" value="提 交" class='catwBtnHover' />
                             </span>
                             </div>
                         </form>
                         <br />
                     </div>
