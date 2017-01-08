var class_cnt_echart = echarts.init($('#class_cnt_echart')[0]);
var age_cnt_echart = echarts.init($('#age_cnt_echart')[0]);
var sex_cnt_echart = echarts.init($('#sex_cnt_echart')[0]);
class_cnt_echart.showLoading();
age_cnt_echart.showLoading();
sex_cnt_echart.showLoading();
$('document').ready(function(){
	
	$.ajax({
		url: path + '/admin/stu_getStuCntForClass.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			//console.log(rmsg.info);
			class_cnt_echart.hideLoading();
			echartForClass_Cnt(rmsg.info);
			
		}, 
		error : function(){
			layer.msg("出错啦，请尝试刷新！");
		}
	});
	$.ajax({
		url: path + '/admin/stu_getStuAgeGroupByAge.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			//console.log(rmsg.info);
			age_cnt_echart.hideLoading();
			echartForAge(rmsg.info);
		}, 
		error : function(){
			layer.msg("出错啦，请尝试刷新！");
		}
	});
	$.ajax({
		url: path + '/admin/stu_getStuCntForSexByClass.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			//console.log(rmsg.info);
			sex_cnt_echart.hideLoading();
			echartForSex(rmsg.info);
		}, 
		error : function(){
			layer.msg("出错啦，请尝试刷新！");
		}
	});
	
	
	
	/*
	 $.ajax({
		url: path + '/stu/stu_getStuCntForClass.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			console.log(rmsg.info);
			
		}
	});
	
	$.ajax({
		url: path + '/stu/stu_getStuAgeGroupByAge.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			console.log(rmsg.info);
		}
	});
	
	$.ajax({
		url: path + '/stu/stu_getStuCntForSexByClass.php',
		method: 'POST',
		dataType: 'json',
		success: function(rmsg){
			console.log(rmsg.info);
		}
	});
	 */
	
	
	
	

	
});

 
function echartForClass_Cnt(infos){
	var className = new Array();
	var classCnt = new Array();
	for(var i=0 ; i < infos.length; i++){
		className[i] = infos[i][0];
		classCnt[i] = infos[i][1];
	}
	 // 基于准备好的dom，初始化echarts实例

    var dataAxis = className;
    var data = classCnt;
    var yMax = 35;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
        title: {
            text: '班级-学生统计图',
            left: 60
           // subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
        },
        xAxis: {
            data: dataAxis,
            axisLabel: {
                inside: true,
                textStyle: {
                    color: '#fff'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            z: 10
        },
        yAxis: {
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
        },
        dataZoom: [
            {
                type: 'inside'
            }
        ],
        series: [
            { // For shadow
            	name :'数量',
                type: 'bar',
                itemStyle: {
                    normal: {color: 'rgba(0,0,0,0.05)'}
                },
                barGap:'-100%',
                barCategoryGap:'40%',
                data: dataShadow,
                animation: false
            },
            {
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#83bff6'},
                                {offset: 0.5, color: '#188df0'},
                                {offset: 1, color: '#188df0'}
                            ]
                        )
                    },
                    emphasis: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#2378f7'},
                                {offset: 0.7, color: '#2378f7'},
                                {offset: 1, color: '#83bff6'}
                            ]
                        )
                    }
                },
                data: data
            }
        ]
    };

    // Enable data zoom when user click bar.
    var zoomSize = 6;
    class_cnt_echart.on('click', function (params) {
        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
        myChart.dispatchAction({
            type: 'dataZoom',
            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
        });
    });
    
    // 使用刚指定的配置项和数据显示图表。
    class_cnt_echart.setOption(option);
	
}


function echartForAge(infos){
	var Objs = [];
	for(var i=0; i<infos.length; i++){
		Objs[i] = new Object();
		Objs[i].value = infos[i][1];
		Objs[i].name = infos[i][0] + '岁' ;
	}
	//console.log(Objs);
	
	
	option = {
		title : {
			text : '学生年龄统计图',
			/*subtext : '纯属虚构',*/
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
		},
		series : [ {
			name : '学生年龄',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : Objs,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	age_cnt_echart.setOption(option);
	
}


function echartForSex(infos){
	var classeAgeCnt = new Object();
	
	for(var i=0; i < infos.length; i++){
		if(classeAgeCnt [infos[i][0]] == null){
			classeAgeCnt [infos[i][0]]  = new Object();
		}
		classeAgeCnt [infos[i][0]][infos[i][1]] = infos[i][2];
	}
	
	//console.log(classeAgeCnt);
	var classNameData = [];
	var classCntData = [];
	var sexCntData = [];
	
	var i = 0;
	var j = 0;
	for(var className in classeAgeCnt){
		var classCntObj = new Object();
		
		classCntObj.name = className;
		classCntObj.value = classeAgeCnt[className]['男'] + classeAgeCnt[className]['女'];
		classCntData[i] = classCntObj;
		
		for(var sex in classeAgeCnt[className]){
			var SexCntObj = new Object();
			SexCntObj.name = sex;
			SexCntObj.value = classeAgeCnt[className][sex];
			sexCntData[j++] = SexCntObj;
		}
		
		classNameData[i++] = className;
	}
//	console.log(classCntData);
//	console.log(classNameData);
//	console.log(sexCntData);
	
	

	option = {
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        x: 'left',
	        data: classNameData
	    },
	    series: [
	        {
	            name:'班级',
	            type:'pie',
	            selectedMode: 'single',
	            radius: [0, '30%'],

	            label: {
	                normal: {
	                    position: 'inner'
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data: classCntData
	        },
	        {
	            name:'性别',
	            type:'pie',
	            radius: ['40%', '55%'],

	            data:sexCntData
	        }
	    ]
	};
	
	sex_cnt_echart.setOption(option);
	
}

