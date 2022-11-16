function subimt() {
    var user = $('#user').val()
    var password = $('#pass').val()
    var steps = $('#step').val()
    var timedOrNot = $('#timedOrNot').val()

    var mailboxRegExp = new RegExp('^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$');
    var phoneRegExp = new RegExp("^1[3|4|5|7|8][0-9]{9}$");

    if (user == null || user === '') {
        showMessage('用户名不能为空！', 0)
        return
    } else if (!mailboxRegExp.test(user) && !phoneRegExp.test(user)) {
        showMessage('用户名格式有误！', 0)
        return
    }

    if (password == null || password === '') {
        showMessage('密码不能为空！', 0)
        return;
    } else if (password.length < 8) {
        showMessage('密码不能少于8位！', 0)
        return
    }

    let queryUrl;

    if (timedOrNot === '0') {
        queryUrl = '/mi/submit?user=' + user + '&password=' + password + '&steps=' + steps
    } else {
        queryUrl = '/mi/add?user=' + user + '&password=' + password + '&steps=' + steps
    }
    axios.get(queryUrl)
        .then(res => {
            if (res.data.code === 200) {
                showMessage(res.data.msg, 1);
            } else {
                showMessage(res.data.msg, 0);
            }
        }).catch(err => {
        console.log(err)
    })

}


function showMessage(message, type) {
    let messageJQ = $("<div class='showMessage'>" + message + "</div>");
    if (type === 0) {
        messageJQ.addClass("showMessageError");
    } else if (type === 1) {
        messageJQ.addClass("showMessageSuccess");
    }
    // 先将原始隐藏，然后添加到页面，最后以400毫秒的速度下拉显示出来
    messageJQ.hide().appendTo("body").slideDown(300);
    // 4秒之后自动删除生成的元素
    window.setTimeout(function () {
        messageJQ.show().slideUp(300, function () {
            messageJQ.remove();
        })
    }, 3000);
}