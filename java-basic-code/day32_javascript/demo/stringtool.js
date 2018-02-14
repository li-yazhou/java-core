/**
 * @author Administrator
 */
/**
 * 字符串对象新功能，去除字符串两端的空格。 
 */
String.prototype.trim = function(){
				
	var start,end;
	start=0;
	end=this.length-1;
	
	while(start<=end && this.charAt(start)==' '){
		start++;
	}
	while(start<=end && this.charAt(end)==" "){
		end--;
	}
	
	return this.substring(start,end+1);

}
			

/**
 * 字符串新功能，添加一个将字符串转成字符数组。 
 * 返回一个数组
 */
String.prototype.toCharArray = function(){
	
	//定义一个数组。
	var chs = [];
	//将字符串中的每一位字符存储到字符数组中。 
	for(var x=0; x<this.length; x++){
		
		chs[x] = this.charAt(x);
	}
	
	return chs;
	
}


/**
 * 添加一个，将字符串进行反转的方法。 
 */

String.prototype.reverse = function(){
	
	
	var arr = this.toCharArray();
	
	//将数组位置置换功能进行封装。并定义到了反转功能内部。 
	function swap(arr,a,b){
		var temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	for(var x=0,y=arr.length-1;  x<y ; x++,y--){
		
		swap(arr,x,y);
	}
	return arr.join("");
}
/*
String.prototype.toString = function(){
	
	return "mystring:"+this;
}

*/






