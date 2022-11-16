function help1() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>账号密码正确但还是提示错误?</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">如遇账号密码正确但还是提示错误，请尝试手动登录小米运动APP后等待几分钟再试</div>'
    });
}

function help2() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>Zepp Life(原小米运动)app被退出?</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">因本程序是直接通过官方的接口登录你的账号提交新的步数，所以每次使用都会导致Zepp Life(原小米运动)APP上的账号被退出</div>'
    });
}

function help3() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>提交成功但是步数不同步?</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">1.检查Zepp Life(原小米运动)APP内第三方接入内绑定的微信、支付宝等平台是不是你的账号<br>2.同账号当天连续提交太多次<br>3.如果微信步数一直是0步，可能是被举报导致不同步，7天后即可自动恢复</div>'
    });
}

function help4() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>如何重新绑定微信?</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">1.微信内取消关注“华米科技”公众号<br>2.扫描Zepp Life(原小米运动)APP内的微信绑定二维码进行绑定</div>'
    });
}

function help5() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>如何清除Zepp Life(原小米运动)APP数据?</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">进入Zepp Life(原小米运动) APP 点 – 我的 – 设置 – 账号与安全 – 点注销账号 – 点清除数据<br>等待几分钟后重新登录Zepp Life(原小米运动)APP并重新绑定微信、支付宝再重试刷步<br>重新绑定微信时需要先取关“华米运动”公众号再扫描绑定二维码即可重新绑定<br>如果清除数据后重新绑定还是无法刷步，则直接注销Zepp Life(原小米运动)APP账号然后重新注册绑定后再试</div>'
    });
}

function help6() {
    layer.open({
        type: 1,
        offset: '100px',
        shadeClose: true,
        closeBtn: 0,
        area: 'auto;',//提示窗宽度
        btn: ['我晓得了'],//按钮
        title: '<strong>正确的刷步姿势：</strong>',//标题
        content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;">1.当天提交总提交次数建议不要超过5次，并且间隔几小时提交一次，请合理分配步数。<br>2.当天每次提交的步数应该比上一次提交更多，保证步数上升的稳定性</div>'
    });
}