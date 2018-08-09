local function async(handler)
    local runn = coroutine.running()
    handler(function()
        coroutine.resume(runn)
    end)
    coroutine.yield()
end



function sleep()
    local interval = math.floor(math.random() * 1000)
    -- local interval = 10
    local starttime = os.time()
    while os.time() - starttime < interval do 
    end
    print(interval, "\n")
end


function f1() 
    print("f1...")
    sleep()
end


function f2() 
    print("f2...")
    sleep()
end


function f3() 
    print("f3...")
    sleep()
end


function f4() 
    print("f4...")
    sleep()
end


function f5() 
    print("f5...")
    sleep()
end


function f()
    local co = coroutine.create(function()
        async(f1)
        async(f2)
        async(f3)
        async(f4)
        async(f5)
    end)
    coroutine.resume(co)
end

f()


