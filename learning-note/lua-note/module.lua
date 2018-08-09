
-- 2018-3-12 10:48:25

-- 文件名 module.lua
-- 定义一个名为 module 的模块
module = {}

-- 定义一个常量
module.constant = "this is a constant";


-- 定义公有函数
function module.func1()
	io.write("this is a common function");
end


-- 定义私有函数
local function func2()
	print("thisi is a private function");
end


-- 公有函数调用私有函数，私有函数间接被外界访问
function module.func3()
	func2();
end

return module




