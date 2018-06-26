/**
 * @author Administrator
 */

/**
 * 数组获取最大值的方法。 
 */

Array.prototype.getMax = function(){
	
	var temp = 0;
	for(var x=1; x<this.length; x++){
		if(this[x]>this[temp]){
			temp = x;
		}
	}
	return this[temp];
}

/*
 * 数组的字符串表现形式。 
 * 定义toString方法。 相当于java中的复写。 
 * 
 */
Array.prototype.toString = function(){
	
	return "["+this.join(", ")+"]";
}





