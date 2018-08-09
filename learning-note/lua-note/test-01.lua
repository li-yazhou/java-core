function simple_tab_to_json(tab)
    if tab == nil then
		return ""
	end
    local jsonstr = "{"
    for k, v in pairs(tab) do
        jsonstr = jsonstr .. "\"" .. k .. "\"" .. ":" .. "\"" .. v .. "\"" .. ","
    end
	jsonstr = string.sub(jsonstr, 1, -2)
    jsonstr = jsonstr .. "}"
    return jsonstr
end



local log_item = {
    ["time"] = "a",
    ["key"] = "b",
    ["hostname"] = "c",
    ["processState"] = "0", -- 默认是0，表示请求成功
    ["elapsedTime"] = "d"
}
local jsonstr = simple_tab_to_json(log_item)
print(jsonstr)
