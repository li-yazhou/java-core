
forward_log_tab= {"a", "b", "c", "d", "e"}
local log_path = "forward.log"
local log_file = io.open(log_path, "a")
io.output(log_file) --设置默认输出文件
for _, v in ipairs(forward_log_tab) do
    io.write(v)
    io.write("\n")
end
forward_log_tab = {}
io.close(log_file)
