<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cmn-Hans">
<head>
<title>称骨算命</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/npm.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/suan.js"></script>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />


<style type="text/css">
* {
    box-sizing: border-box;
}


body, h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4 {
    font-family: 'Roboto', 'Helvetica', 'Arial', sans-serif;
    font-weight: 300;
    line-height: 1.42857143;
}

.header-panel {
    background-color: #9999CC;
    height: 144px;
    position: relative;
    z-index: 3;
    box-shadow: 0 0 4px rgba(0,0,0,.14),0 4px 8px rgba(0,0,0,.28);
}

.header-panel div {
    position: relative;
    height: 100%;
}




.header-panel h1 {
    color: #FFF;
    /*font-size: 20px;*/
    /*font-weight: 400;*/
    position: absolute;
    bottom: 20px;
    padding-left: 45px;
}

.pages {
    position: absolute;
    top: 0;
    right: 0;
    z-index: 4;
    padding: 0;
    overflow: auto;

}

.guo{
font-size:20px;

}

.pages > div {
    padding: 0 5px;
    padding-top: 64px;
    margin: 0;
}

.pages .header {
    color: #663366;
    /*font-size: 24px;*/
    /*font-weight: normal;*/
    /*margin-top: 5px;*/
    /*margin-bottom: 60px;*/
    /*letter-spacing: 1.20000004768372px;*/
}

.container-fluid .well {

    box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 8px;
    background:#ffffff;
}
</style>
</head>
<body>



  <div class="header-panel shadow-z-2">
    <div class="container-fluid">
      <div class="row">
        <div class="col-xs-3">
          <h1>称骨算命</h1>
        </div>
      </div>
    </div>
  </div>

  <div class="container-fluid main">
    <div class="row">
      <nav class="col-xs-2 menu">
      </nav>

      <div class="pages col-xs-10">
        <div class="row">
          <div class="col-xs-10  guo">
          
             <div class="well page" id="guo" style="display:none;">
              <h1 class="header" id="xingming">结果是</h1>


              <br>
              <br>


                  <div class="row">
                      <div class="col-lg-3 text-right text-info">
                        阴历生日
                      </div>

                      <div class="col-lg-3 text-muted text-left" id="lunar">

                      </div>

                      <div class="col-lg-3 text-right text-info">
                        生肖
                      </div>

                      <div class="col-lg-3 text-muted text-left" id="shengxiao">

                      </div>
                  </div>

                  <div class="row">
                      <div class="col-lg-3 text-right text-info">
                        生辰八字
                      </div>

                      <div class="col-lg-3 text-muted text-left" id="shengchen">

                      </div>

                      <div class="col-lg-3 text-right text-info">
                        骨重
                      </div>

                      <div class="col-lg-3 text-muted text-left" id="guzhong">

                      </div>
                  </div>
<br>
              <br>
                  <div class="row" >
                  			<div class="col-lg-3 text-muted" > </div>
							<div class="col-lg-8 text-muted" id="content"> </div>
							<div class="col-lg-3 text-muted"> </div>
                     
                  </div>

            </div>
          
            <div class="well page" id="jiao">
              <h1 class="header">作者:袁天罡（唐）</h1>

              <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称骨算命是算命方法的一种，和生辰八字算命、紫微斗数算命异曲同工，略有不同，虽然都是用出生的时间算命，但比较而言，称骨算命将命运分的比较粗略，只是把命运分为五十一种，故对命运的考察不细致，不太准确，可以供求测者参考。
              </h3>

              <br>
              <br>
              <form role="form" action="testv" method="post" name="testv">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <input id="xing" class="form-control input-lg" type="text" placeholder=" 姓氏（汉字）"  pattern="^[\u4E00-\u9FA5]+$" name="xing"/>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-lg-6">
                        <div class="form-group">
                            <input  id="ming" class="form-control input-lg" type="text" placeholder=" 名字（汉字）"  pattern="^[\u4E00-\u9FA5]+$" name="ming"/>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                </div><!-- /.row -->

                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group input-lg">
                          出生日期（阳历）
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="form-group">
                            <input id="date" class="form-control input-lg" type="date" name="date"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group input-lg">
                          出生时间
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="form-group">
                            <input id="time" class="input-lg" type="range"  onchange="change()" min="0" max="23" value="1" name="time"/>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                          <div class="input-lg" id="show">1点</span>
                        </div>
                    </div>
                </div>

                  <div class="form-group">
                    <button type="button" id="tijiao_btn" class="btn btn-info btn-lg center-block">提交</button>
                  </div>

              </form>

              </div>
            </div>
          </div>
        </div>

    </div>
  </div>
</body>
<script>
function change() {
    var x = document.getElementById("time").value;
    document.getElementById("show").innerHTML = x+'点';
}
</script>
</html>