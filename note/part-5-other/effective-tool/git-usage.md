# git-usage


## 常用命令

### revert 与 reset

git revert 撤销某次操作，此次操作之前和之后的commit和history都会保留，并且把这次撤销，作为一次最新的提交。
* git revert HEAD         撤销前一次 commit
* git revert HEAD^        撤销前前一次 commit    
* git revert commit_id   （比如:fa042ce57ebbe5bb9c8db709f719cec2c58ee7ff）


revert与reset对比

git revert是用一次新的commit来回滚之前的commit，git reset是直接删除指定的commit。
这个很好理解，在刚才的操作中我们看日志已经可以看到这个现象。
git reset操作之后，我们查看上面例子的network已经可以看到network中只有commit 1,分支a和合并分支后的commit 3都消失了；
git revert操作之后，network中还是可以看到a分支和合并a分支的操作，只不过在其基础上又增加了一个revert的commit而已。


git reset 是把HEAD向后移动了一下，而git revert是HEAD继续前进，只是新的commit的内容和要revert的内容正好相反，能够抵消要被revert的内容。


在回滚这一操作上看，效果差不多。但是在日后继续merge以前的老版本时有区别。因为git revert是用一次逆向的commit“中和”之前的提交，因此日后合并老的branch时，导致这部分改变不会再次出现，但是git reset是之间把某些commit在某个branch上删除，因而和老的branch再次merge时，这些被回滚的commit应该还会被引入。


### rebase


---


## 常用功能

###  查看单个文件的修改历史

查看fileName相关的commit记录
> git log filename

显示每次提交的diff
> git log -p filenam

只看某次提交中的某个文件变化，可以直接加上fileName
> git show c1mnff0 filename


---






















































