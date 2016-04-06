function validateForm(updateId, jsondata) {
	var validateText = "";
	for ( var key in jsondata) {

		// alert("对应的值是" + jsondata[key]);
		var key_ = key;
		var rule = jsondata[key_]; // 验证规则
		// console.log("keyy:"+keyy);
		// console.log("index:"+keyy.indexOf('validate_'));

		if (key_.indexOf('validate_') != -1) {
			// alert("Key是" + key);

			var verfiyed = key_.substring(key_.indexOf('validate_') + 9,
					key_.length);
			var verfiyStr = jsondata[verfiyed] // 需要被验证的内容

			if (rule.indexOf(',') != -1) {
				var rules = rule.split(',');
				for ( var dd in rules) {

					var result = validateRule(rules[dd], verfiyStr, jsondata,
							verfiyed, updateId);
					console.log("result:" + result);
					if (result != "" && result != undefined) {

						validateText += result;
						break;
					}

				}
			} else {
				var result = validateRule(rule, verfiyStr, jsondata, verfiyed,
						updateId);
				if (result != "" && result != undefined) {

					validateText += result;
				}

			}

		}
	}
	// '<i class="fa-lg fa fa-warning"></i>用户名不能为空！<br/>&nbsp;<i
	// style="padding-top:6px;" class="fa-lg fa fa-warning"></i>用户名不能为空2！'
	if (validateText != '') {
		var text = validateText.substring(0, validateText
				.lastIndexOf('<br/>&nbsp;'));
		// alert("validateText:"+text);
		Metronic.alert({
			container : '.modal-body',// alerts parent container(by default
			// placed after the page breadcrumbs)
			place : 'prepend', // append or prepent in container
			type : 'success', // alert's type
			message : text, // alert's message
			close : false, // make alert closable
			reset : true,
			// closeInSeconds:2, // auto close after defined seconds
			cssStyle : 'padding: 5px;margin-bottom: 10px;color:#C0334A',
			icon : 'none' // put icon before the message
		});

		return 1;

	}
}

function validateRule(rule, verfiyStr, jsondata, verfiyed, updateId) {

	console.log("========================================== " + rule + "   "
			+ verfiyStr + "   " + JSON.stringify(jsondata) + "   " + verfiyed);
	if (rule.match('length*') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var between = rule.substring(rule.indexOf('[') + 1,
					rule.indexOf(']')).split('-');
			if (!(verfiyStr.length >= between[0] && verfiyStr.length <= between[1])) {
				// alert(jsondata["friendly_"+verfiyed]+"长度必须在"+between[0]+"至"+between[1]+"之间");
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
						+ jsondata["friendly_" + verfiyed]
						+ "长度必须在"
						+ between[0] + "至" + between[1] + "之间<br/>&nbsp;";
			}
		}
	} else if (rule.match('required') != null) {
		if (verfiyStr == "" || verfiyStr == null
				|| verfiyStr.trim().length == 0) {
			// alert(jsondata["friendly_"+verfiyed]+"不能为空");
			return "<i class='fa-lg fa fa-warning' style='padding-top:6px;'></i>&nbsp;&nbsp;"
					+ jsondata["friendly_" + verfiyed] + "不能为空<br/>&nbsp;";
		}
	} else if (rule.match('onlyNumber') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			if (!new RegExp(/^[0-9]+$/).test(verfiyStr)) {
				// alert(jsondata["friendly_"+verfiyed]+"只能是数字");
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;'></i>&nbsp;&nbsp;"
						+ jsondata["friendly_" + verfiyed] + "只能是数字<br/>&nbsp;";
			}
		}
	} else if (rule.match('email') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			if (!new RegExp(
					/^[a-zA-Z0-9_\.\-]+\@([a-zA-Z0-9\-]+\.)+[a-zA-Z0-9]{2,4}$/)
					.test(verfiyStr)) {
				// alert(jsondata["friendly_"+verfiyed]+"格式不正确");
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
						+ jsondata["friendly_" + verfiyed] + "格式不正确<br/>&nbsp;";
			}
		}
	}

	else if (rule == 'date') {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			if (!new RegExp(
					/^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/)
					.test(verfiyStr)) {
				// alert("请输入有效的"+jsondata["friendly_"+verfiyed]+",如:2008-08-08");
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
						+ "请输入有效的"
						+ jsondata["friendly_" + verfiyed]
						+ ",如:2008-08-08<br/>&nbsp;";
			}
		}
	} else if (rule.match('confirm*') != null) {
		var confirm = rule.substring(rule.indexOf('[') + 1, rule.indexOf(']'));

		if (jsondata[confirm] != "" && verfiyStr != jsondata[confirm]) {
			// alert('两次输入的值不一致123');
			return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
					+ "两次输入的值不一致<br/>&nbsp;";
		}

	} else if (rule.match('number*') != null) {

		var between = rule.substring(rule.indexOf('[') + 1, rule.indexOf(']'))
				.split('-');

		var num = jsondata["validateNumber_" + verfiyed]; // 已选CHECKBOX数量

		if (!(num >= between[0] && num <= between[1])) {
			// alert(jsondata["friendly_"+verfiyed]+"长度必须在"+between[0]+"至"+between[1]+"之间");
			return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;必须选择"
					+ between[0]
					+ "到"
					+ between[1]
					+ jsondata["friendly_" + verfiyed] + "<br/>&nbsp;";
		}

	} else if (rule.match('xml') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var pat = /^<.*>$/;
			if (!pat.test(verfiyStr)) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
						+ jsondata["friendly_" + verfiyed]
						+ "格式不是标准报文<br/>&nbsp;";
			}
		}
	} else if (rule.match('url') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {

			var urlAndErrInfoAndParam = rule.substring(rule.indexOf('(') + 1,
					rule.indexOf(')')).split(';');
			var url = urlAndErrInfoAndParam[0];
			var errInfo = urlAndErrInfoAndParam[urlAndErrInfoAndParam.length - 1];
			var paramJson = {};
			var paramArr = new Array();
			for (i = 1; i < urlAndErrInfoAndParam.length - 1; i++) {
				var param = {};
				param[urlAndErrInfoAndParam[i]] = jsondata[urlAndErrInfoAndParam[i]];
				paramArr[i - 1] = param;
			}
			paramJson["$and"] = paramArr;
			// 拼凑查询的json串
			paramJson = JSON.stringify(paramJson);
			// 请求是否已经存在
			var data = Restful.find(url, paramJson);
			if (data != null && data.length > 0) {
				// data[0].id表示更加条件查询的id，updateId表示是更新时的主键id
				// 主键为id的验证
				if (data[0].id != null) {
					if (data[0].id != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				}
				// 商户维护验证，主键是mchntId
				else if (data[0].mchntId != null) {
					if (data[0].mchntId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				}
				// 产品维护验证，主键是prodId
				else if (data[0].prodId != null) {
					if (data[0].prodId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				}
				// 公共参数验证，主键是paramId
				else if (data[0].paramId != null) {
					if (data[0].paramId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				} else if (data[0].userId != null) {
					if (data[0].userId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				} else if (data[0].roleId != null) {
					if (data[0].roleId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				} else if (data[0].menuId != null) {
					if (data[0].menuId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				} else if (data[0].actionId != null) {
					if (data[0].actionId != updateId) {
						return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
								+ errInfo + "<br/>&nbsp;";
					}
				}
			}
		}
	} else if (rule.match('money') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var between = rule.substring(rule.indexOf('[') + 1,
					rule.indexOf(']')).split('-');
			if (verfiyStr.indexOf(".") > 0) {
				if (verfiyStr.split(".")[0].length > between[0]
						|| verfiyStr.split(".")[1].length > between[1]
						|| !new RegExp(/^[0-9]+$/)
								.test(verfiyStr.split(".")[0])
						|| !new RegExp(/^[0-9]+$/)
								.test(verfiyStr.split(".")[1])) {
					var moneyDemo = "";
					for (i = 0; i < between[0]; i++) {
						moneyDemo = moneyDemo + "9";
					}
					moneyDemo = moneyDemo + ".";
					for (j = 0; j < between[1]; j++) {
						moneyDemo = moneyDemo + "9";
					}
					return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
							+ jsondata["friendly_" + verfiyed]
							+ "的整数部分长度不能大于"
							+ between[0]
							+ "或者小数部分不能大于"
							+ between[1]
							+ "且必须都是数字,例如：" + moneyDemo + "<br/>&nbsp;";
				}
			} else {
				if (verfiyStr.length > between[0]
						|| !new RegExp(/^[0-9]+$/).test(verfiyStr)) {
					var moneyDemo = "";
					for (i = 0; i < between[0]; i++) {
						moneyDemo = moneyDemo + "9";
					}
					return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;"
							+ jsondata["friendly_" + verfiyed]
							+ "的整数部分长度不能大于"
							+ between[0]
							+ "且必须都是数字,例如："
							+ moneyDemo
							+ "<br/>&nbsp;";
				}
			}
		}
	} else if (rule.match('isDbPrompt') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var promptInfo = ("0" == verfiyStr) ? "确认数据库需要备份？" : "确认数据库不需要备份？";
			if (window.confirm(promptInfo)) {
			} else {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;请确实是否需要备份数据库<br/>&nbsp;";
			}
		}
	} else if (rule.match('isSameOper') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			if (verfiyStr == $.cookie('userinfo').username) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;审核人和申请人是同一个人，不能操作。<br/>&nbsp;";
			}
		}
	} else if (rule.match('certNo') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if (reg.test(verfiyStr) === false) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;身份证格式不合法<br/>&nbsp;";
			}
		}
	} else if (rule.match('phone') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var myreg =  /^1\d{10}$/;
			if (!myreg.test(verfiyStr)) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;手机号格式不对<br/>&nbsp;";
			}
		}
	} else if (rule.match('upperCase4') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var myreg = /^[A-Z]+$/;
			if (!myreg.test(verfiyStr)) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;商户编号只能由4位大写字母组成<br/>&nbsp;";
			}
		}
	} else if (rule.match('urladdr') != null) {
		if (verfiyStr != "" && verfiyStr.trim().length != 0) {
			var myreg = "/^[A-Za-z]+://[A-Za-z0-9-_]+\\.[A-Za-z0-9-_%&\?\/.=]+$/;"
			if (!myreg.test(verfiyStr)) {
				return "<i class='fa-lg fa fa-warning' style='padding-top:6px;' ></i>&nbsp;&nbsp;URL地址不合法<br/>&nbsp;";
			}
		}
	}
}

function validateCustom(element) {
	$('.Metronic-alerts').remove();
	// console.log("parent:"+$("#oldPassword").parent().prev().text().trim());
	var validates = $(element).find("[class*=validate]");
	var sendjson = {};
	var validateText = "";
	// 拼接json
	$.each(validates, function(index, item) {

		var text = item.value; // 需要验证的值
		var id = item.id; // 被验证对象的ID（唯一）
		if (item.type != undefined && item.type == "checkbox") {
			sendjson["validateNumber_" + id] = $(element).find(
					"input[name='" + item.name + "']:checked").length;
			// sendjson["validateNumber_"+id] =item.name;
		}
		var rule = $("#" + id).attr("class");
		var conditions = rule.substring(rule.indexOf('validate[') + 9, rule
				.lastIndexOf(']')); // .split(',');
		// //需要验证的规则
		var labelName = $("#" + id).closest('label').prev().text().trim(); // 被验证字段的诠释
		sendjson["validate_" + id] = conditions;
		sendjson[id] = text;
		sendjson["friendly_" + id] = labelName;
	});
	// console.log("sendjson:"+JSON.stringify(sendjson));
	return validateForm(validateText, sendjson);
}
