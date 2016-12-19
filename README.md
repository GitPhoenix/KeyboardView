# KeyboardView 自定义安全键盘
######效果图：![keyboardView](https://github.com/GitPhoenix/KeyboardView/blob/master/art/keyboardView.gif)

具体使用
```
editView.setEditView(llKeyboard, keyboardView, true);

editView.setOnKeyboardListener(new EditView.OnKeyboardListener() {
	@Override
	public void onHide(boolean isCompleted) {
		if (height > 0) {
			llGuan.scrollBy(0, -(height + DensityUtil.dp2px(MainActivity.this, 16)));
		}

		if (isCompleted) {
			Log.i("", "你点击了完成按钮");
		}
	}

	@Override
	public void onShow() {
		llGuan.post(new Runnable() {
			@Override
			public void run() {
				//pos[0]: X，pos[1]: Y
				int[] pos = new int[2];
				//获取编辑框在整个屏幕中的坐标
				editView.getLocationOnScreen(pos);
				//编辑框的Bottom坐标和键盘Top坐标的差
				height = (pos[1] + editView.getHeight())
						- (ScreenUtil.getScreenHeight(MainActivity.this) - keyboardView.getHeight());
				if (height > 0) {
					//编辑框和键盘之间预留出16dp的距离
					llGuan.scrollBy(0, height + DensityUtil.dp2px(MainActivity.this, 16));
				}
			}
		});
	}

	@Override
	public void onPress(int primaryCode) {

	}
});
```
llKeyboard为包裹键盘的父布局，llGuan为包裹输入框的父布局。
