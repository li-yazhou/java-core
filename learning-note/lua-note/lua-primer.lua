
-- 目录


-- Lua基本语法
-- lua 数据类型
-- lua 变量
-- 三大循环
-- 流程控制
-- Lua函数
-- Lua运算符
-- Lua字符串
-- Lua数组
-- Lua迭代器
-- Table
-- 模块与包
-- 元素(Metatable)
-- 协同程序(CoRoutine)
-- 文件 I/O
-- 错误处理
-- 调试(Debug)
-- 垃圾回收
-- 面向对象
-- 数据库访问
-- 5.3参考手册




---------------------------
-- Lua基本语法

-- 使用 lua -i 启动交互式式模式


-- this is comment

--[[
	this is multi-lines comment
]]


--方便取消注释
--[[
	this is multi-lines comment
--]]


---[[
	print("取消多行注释");
--]]

-- 多行注释推荐使用 --[=[注释内容]=]，这样可以避免遇到table[table[idx]]时就将多行注释结束了。




-- 使用如下代码指定解释器所在位置
-- #!/usr/local/bin/lua


print("Hello world.");


-- lua 的关键字
--[[
	and, break, do, else,
	elseif, end, false, for,
	function, if, in, local,
	nil, not, or, repeat,
	return, then, true, until,
	while
--]]


-- 默认情况下，变量都是全局的

-- 一般约定，一下划线开头连接一串大写字母的名字，被保留用于Lua内部全局变量。

-- 删除一个全局变量，只需要将变量赋值为nil



---------------------------
-- lua 数据类型

--[[
	Lua是动态类型语言，变量没有类型

	Lua中有8个基本类型，分别为
			nil,
			boolean,
			number,
			string,
			userdata,
			function,
			thread,
			table

		检测变量或值的类型的函数是：
			type(变量or值)， 该函数返回值是字符串
				type(type(type))
					-- type(type)返回"function"
					-- type("function")返回string
				type(type("str"))
				type("Hello world")
				type(print)
				type(type)
--]]

-- nil类型
	--[[
		对全局变量和table中的键值对有删除的作用

			tab = {k1="v1", k2="v2"}
		    for k, v in pairs(tab) do
			   print(k .. "-" .. v)
			end

			result:
				k1-v1
				k2-v2

			tab.k1 = nil, 即可删除掉k1-v1键值对
	--]]



-- boolean类型
	--[[
		Lua语言的if判断语句中 false和nil均为假，其他为真

			if false or  nil then
				print("false, nil至少有一个为真")；
			else
				print("均为假");	
			end
			
	--]]



-- number
	--[[
		Lua的number的默认类型是双精度类型double,
		可以在 luaconf.h文件中定义
	--]]



-- string
	--[=[
		使用[[]]表示一块字符串，比如
			lines = [[
				今天是2018-3-9 11:42:47
				today is friday.
			]]


		对一个数字字符串进行算术操作时，Lua会尝试将该数字字符串转换为一个数字


		字符串连接符是 ..，非数字类型的字符串与数字不可进行加"+"操作


		使用#可以计算字符串的长度，放在字符串的前面，如下
			len = #"lyz";
	]=]



-- table
	--[=[
		
		table 和 php中的关联数组是一样的，关联数组的索引是数字或者字符串
			当指定key时，table可以作为关联数组使用，也即是Java中的Map
			当没有指定key时，table可以作为普通数组使用
			混合使用，一部分数据指定key，一部分不指定key，
				则不指定的部分的数据的key是从1开始计算的，不断增长


		使用构造表达式创建table(表)
			创建空表
				local tab1 = {}
				tab1["k1"] = "v1";
				tab1[5] = "v2";

			直接初始表
				tab2 = {"apple", "pear", "grape", "orange"};	
				-- 该数据没有指定键，则键为从1开始的索引
				--## 2018-3-9 12:00:28

				-- key是字符串类型的，不用使用双引号显式表示了
				tab = {a="apple", b="banana"};
			
		
		遍历table，使用forin语句
			for k, v in pairs(tab) do
				print(k .. " - " .. v);
			end


		Lua的table表的默认索引是从1开始的。


		访问关联数组中的元素
			tab['a']
			tab.a  ，是对上一种写法的简化
		访问数组中的元素
			tab[index]	


		for循环
			for i = 1, 10 do
				print(i);
			end

	]=]




-- function
	--[=[
		在Lua中，函数被看作是"第一类值"（First-Class Value)，变量可以引用函数

		函数可以作为参数传递
			-- 定义函数
			function func(k, v)
				return k .. " - " .. v;
			end

			function iterTableElement(tab, func)
				for k, v in pairs(tab) do
					print(func(k, v));
				end
			end		

			tab = {"apple", "orange", "pear"};

			iterTableElement(tab, func);


		-- Lua支持匿名函数，没必要定义只使用一次
		iterTableElement(tab, function(k, v)
								return k .. " - " .. v;
							  end	
		);

	]=]



-- thread
	--[=[
		在Lua中，最主要的线程是协同程序（coroutine）。
		它跟线程（thread）差不多，它们都拥有自己独立的栈、局部变量和指令指针，
		可以跟其它协同程序共享全局变量和其他大部分东西。

		线程跟协程的区别：
			线程可以同时多个运行，
			而协程任意时刻只能运行一个，并且处于运行状态的协程只有被挂起（suspend)时才会暂停。
	]=]


-- userdata
	--[=[
		userdata(自定义类型)
		userdata是一种用户自定义数据，用于表示一种由应用程序或C/C++语言所创建的类型，
		可以将任意C/C++的任意数据类型的数据（通常是struct和指针）存储到Lua变量中调用。
	]=]



---------------------------
-- lua 变量

	--[=[
		Lua变量有三种类型：
			全局变量
			局部变量
			表中的域


		Lua中的变量均为全局变量，包括在语句块或函数中声明的变量，
			除非使用local显式地声明为局部变量。


		局部变量的作用域为从声明位置开始到所在语句块结束。（局部变量只能在语句块中声明）
			do
				local a = 11;  -- 局部变量
				b = 22;        -- 全局变量
				print(a, b);
			end
			
			代码块
				以end为结尾的，
				以do，function等关键字开始的。

		
		应该尽量的使用局部变量，有两个好处：
			避免命名冲突
			访问局部变量的速度比全局变量更快				

		
		变量的默认值均为 nil。


		赋值语句
			Lua可以对多个变量同时赋值
				a, b = 11, 22;
				交换两个变量的值
					x, y = y, x;
			
			多值赋值经常用来交换变量的值，或将函数返回值赋值给变量
				a, b = func();

		
		表中的域
			对于数字索引的table，使用tab[index]访问表中的元素
			对于字符串索引的table，使用tab["key"]或tab.key访问表中的元素

	]=]



---------------------------
-- 三大循环
	--[=[
		(1) while循环
		(2) for循环
		(3) repeat...util


		(1) while循环
			while(true)
			do 
				print("while loop");
			end


		(2) for循环
			for var = initVal, endVal, step do
				print("循环体");
			end
			其中 var = [initVal, endVal)，defalut step = 1 可以省略。

			for i = 10, 0, -1 od
				print(i);
			end	 


			泛型for循环
				泛型for循环通过一个迭代器函数遍历table中的元素。
				for i, v in iparis(tab) do
					print(i, v);
				end


		(3) repeat...until
			repeat
				statements
			until(condition)

			相当于其他语言中do..while循环，至少会执行一次


		break关键字
			a = 1;
			while(a < 20)
			do
				a = a + 1;
				if (a > 10) 
				then
					break;
				end
				print(a);
			end
	]=]


---------------------------
-- 流程控制
	--[=[
		(1) if语句
		(2) if..else语句
		(3) if嵌套语句，if..elseif..elseif..else

		条件为真为假
			条件结果为false或者nil时，条件为假
			其他情况条件结果为真，包括0

		(1) if语句
			age = 12;
			if (age < 18)
			then
				print("未成年");
			end	

		(2) if...else语句
			if(condition)
			then
				statement1;
			else
				statement2;
			end


			age = 12;
			if (age < 18)
			then
				print("未成年");
			else
				print("成年");
			end

		(3) if嵌套语句，if..elseif..elseif..else
			if
			then
				statement1;
			elseif
			then
				statement2;
			elseif
			then
				statement3;
			else
				statement4;
			end


			age = 55;
			if (age < 18) then print("未成年");
			elseif(age < 40) then print("青年人");
			elseif(age < 60) then print("中年人");
			else print("老年人"):
			end
	]=]




---------------------------
-- Lua函数
	--[=[
		函数，function，即功能之意，函数是用来完成某种功能的代码

		函数定义
			optional_function_scope function function_name(arg1, arg2, ..., arg3)
				function_body
				return result_params;
			end

		其中，
			optional_function_scope 指定该函数是全局函数还是局部函数，缺省该参数表示全局函数。
				声明局部函数的方式是将其设置为local

			result_params，表示函数的返回结果，结果包括多个值时，相邻值之间使用逗号隔开

		function max(a, b)
			if (a < b) 
			then a = b;
			end
			return a;
		end

		多个返回值
			s, e = string("www.test.com", "test");
			print(s, e); 
			-- [s, e] = 5, 8


		返回数组中的最大值和索引
		function maximum(tab)
			local maxIndex = 1;
			local maxVal = tab[maxIndex];
			for i, val in ipairs(tab) do
				if (maxVal < val)
				then
					maxVal = val;
					maxIndex = i;
				end
			end
			return maxVal, maxIndex;
		end


		可变参数
			Lua函数可以接受可变数目的参数，
			和C语言类似，在函数参数列表中使用三点(...)表示函数有可变的参数
			Lua将函数的参数放在arg的表中，
			#arg表示传入参数的个数（# 可以计算字符串的长度）

			例如，计算若干个数的平均值

			function average(...)
				local arg = {...};  -- 接收参数
				local len = #arg;
				-- local len = select("#", ...);
				local sum = 0;
				for i, v in pairs(arg) do
					sum = sum + v;
				end
				return sum / len;
			end


	]=]



---------------------------
-- Lua运算符
	--[=[
		
		(1) 算术运算符
			+, -, *, /, %, ^, -(负号)

		(2) 关系运算符
			==
			~=
			>
			>=
			<
			<=

		(3) 逻辑运算符
			and
			or
			not
		

		(4) 其他运算符
			..，连接符，将两个变量连接为一个字符串
			#，计算长度符号，返回字符串或表的长度
				len = #str
				len = #tab
	]=]


---------------------------
-- Lua字符串
	--[=[
		Lua定义字符串的三种方式：
			单引号包含的字符串
			双引号包含的字符串
			[[和]]之间的多行字符串


		字符转义符号
			"\"


		字符串操作
			string.upper(argument)

			string.lower(argument)

			string.gsub(mainString, findString, replaceString[, num])
				num 表示替换的次数，缺省时表示全部替换

			string.find(str, substr, [initIndex, [endIndex]])
				返回子字符串在字符串中的起始位置，[s, e]，下表从1开始计算

			string.reverse(arg)

			string.format(...)
				string.format("the value is:%d", 4);

			string.char(args)，将整型数字转换成字符并连接
				string.char(97, 98, 99), 返回abc

			string.byte(arg[, index])，将索引为index的字符转换为整数，
				index可以为负整数，-1表示倒数第一个字符

			string.len(arg)

			string.rep(str, n)，返回字符串的n个拷贝拼接而成的字符串
				string.rep(abc, 3), abcabcabc

			..
				连接两个字符串

			string.gmatch(str, pattern)
				返回一个迭代器函数，每次调用这个函数，
				返回一个在字符串str找到的下一个符合pattern描述的子串
			
			string.match(str, pattern, initIndex)
				返回第一个满足查询条件的结果
				string.match("I have 2 questions for you.", "%d+ %a+")
					结果为 2 question


			模式匹配
			
	]=]



---------------------------
-- Lua数组

	--[=[
		一维数组
			array = {"apple", "orange"};

		多维数组
			array = {};
			for i = 1, 3 do
				array[i] = {};
				for j=1, 3 do
					array[i][j] = i * j;
				end
			end

		访问多维数组
			for i =1, #array do
				for j = 1, #array[i] do
					print(array[i][j]);
				end
			end
	]=]



---------------------------
-- Lua迭代器
	--[=[

		Lua迭代器(Iterator)是一种对象，
			它能够用来遍历标准模板库容器中的部分或全部元素，
			每个迭代器对象代表容器中的确定的地址
			在Lua中迭代器是一种支持指针类型的结构，它可以遍历集合的每一个元素


		(1) 泛型for迭代器
			for i, v in ipairs(tab) do
				print(i, v);
			end


		(2) 无状态的迭代器
			无状态迭代器避免创建闭包花费额外的代价

			无状态迭代器，
				每一次迭代，迭代函数都是用两个变量，状态变量和控制变量的值作为参数被调用，
				一个无状态的迭代器只利用这两个值可以获取下一个元素

			这种无状态迭代器的典型的简单的例子是ipairs，它遍历数组的每一个元素
			（对比python中的迭代器和生成器）

			实现数字n的平方的迭代器
				function square(iteratorMaxCount, currentNumber)
					if currentNumber < iteratorMaxCount
					then 
						currentNumber = currentNumber + 1
					    return currentNumber, currentNumber ^ 2
					end
				end


				for i, n in square, 3, 0 do  -- 调用迭代器的方式 iter, arg1, arg2
					print(i, n)
				end

				结果为：
					1	1
					2	4
					3	9

			迭代的状态包括被遍历的表和当前的索引下标，
			其中，
				被遍历的表在循环过程中是不会改变的状态变量
				当前的索引下标是控制变量

			ipairs和迭代函数可以这样实现：


		(3) 多状态的迭代器



	]=]


---------------------------
-- Table
	--[=[
		table可以创建数组或关联数组（字典）。
		可以用使用任意类型的值作为关联数组的索引，但这个值不可以为nil。
		Lua通过table解决模块（module）、包（package）和对象（Object）的。
			例如，string.format使用format索引table string。

		创建和初始化表
			-- 创建空表
			tab = {};
			-- 对空表进行初始化
			tab[1] = "lua";

			-- 创建并初始化表
			tab = {"lua", "c", "c++"};
			tab = {
				[1] = "lua",
				[2] = "c", 
				[3] = "c++"
			};


			-- 移除引用，lua垃圾回收会释放内存
			tab = nil;


			table 操作
				table.concat(table [, sep [, start [, end]]])
					默认是sep="", start=1, end=#tab, [start, end]。
					function printTable()
						local result = table.concat(tab, ", ");
						print(result);
					end

				table.insert(table [,pos], value)
					默认是在数组默认添加元素。

				table.remove(table [, pos])
					返回并删除指定索引的元素，pos默认值是#table的长度，即从最后一个元素操作。

				table.sort(table[, comp])
					对table升序排序

			table最大值
				table.maxn在Lua5.2之后不提供支持，自定义table_maxn方法实现。
				function table_maxn(tab)
					local max = nil;
					for k, v in pairs(tab) do
						if (max == nil or max < v)
						then max = v;
						end
					end
					return max;
				end


			table的长度
				使用 #tab 和 table.getn(tab)，都会在索引中断的地方停止计数，导致无法正确取得table的长度。
				比如，tab = {
					[1] = "lua", 
					[3] = "c",
					[5] = "c++"
				};
				#tab 和 table.getn(tab) 的返回值均为 1。

				自定义计算table长度的方法
					function table_len(tab)
						local len = 0;
						for k, v in pairs(tab) do
							len = len + 1;
						end
						return len;
					end	
	]=]

	local corp = {
	    web = "www.google.com",   			--索引为字符串，key = "web", value = "www.google.com"
	    telephone = "12345678",   			--索引为字符串
	    staff = {"Jack", "Scott", "Gary"},  --索引为字符串，值也是一个表
	    100876,              	 			--相当于 [1] = 100876，此时索引为数字，key = 1, value = 100876
	    100191,              	 			--相当于 [2] = 100191，此时索引为数字
	    [10] = 360,              			--直接把数字索引给出
	    ["city"] = "Beijing"     			--索引为字符串
	}



---------------------------
-- 模块与包
	--[=[
		模块类似于一个封装库，从Lua5.1开始加入标准的模块管理机制，
		可以把公用的代码放在一个文件中，以API接口的形式供其他代码调用，
		有利于提高代码的复用性和降低代码的耦合度。

		Lua模块是由变量、函数等已知元素组成的table，因此创建一个模块就是创建一个table，
		然后把需要导出的常量、函数放入其中，最后返回table即可，
		比如自定义模块module.lua的代码如下：
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



		reuqire函数
			-- import and revoke module
			-- require("module_name")
			require("module");
			-- require("module.lua"), 不可以
			print(module.constant);
			module.func1();


		加载机制
			require函数会根据文件路径加载策略，尝试从Lua文件或C程序库中加载模块。
			require用于搜索Lua文件的路径是存放在全局变量package.path中，
				当Lua启动后，会以环境变量LUA_PATH的值来初始化环境变量，
				如果没有找到该环境变量，则使用一个编译时定义的默认路径来初始化。

			package.loadfile
			package.cpath
			package.loadlib


		C包

	]=]


---------------------------
---------------------------
-- 元素(Metatable)
	--[=[
		

	]=]



---------------------------
-- 协同程序(CoRoutine)



---------------------------
-- 文件 I/O



---------------------------
-- 错误处理


---------------------------
-- 调试(Debug)


---------------------------
-- 垃圾回收


---------------------------
-- 面向对象


---------------------------
-- 数据库访问


---------------------------
-- 5.3参考手册


---------------------------



---------------------------


















