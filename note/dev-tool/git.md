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



### 本地和远程分支关联

> git branch --set-upstream-to=origin/dev dev

---































# git-cheat-sheet


## CONFIGURE TOOLING
Configure user information for all local repositories

> $ git config --global user.name "[name]" <br/>
> Sets the name you want atached to your commit transactions
> 
> $ git config --global user.email "[email address]" <br/>
> Sets the email you want atached to your commit transactions
> 
> $ git config --global color.ui auto <br/>
> Enables helpful colorization of command line output


---


## MAKE CHANGES
Review edits and craf a commit transaction

> $ git status <br/>
> Lists all new or modified files to be commited
> 
> $ git add [file] <br/>
> Snapshots the file in preparation for versioning
> 
> $ git reset [file] <br/>
> Unstages the file, but preserve its contents
> 
> $ git diff <br/>
> Shows file differences not yet staged 
> 
> $ git diff --staged <br/>
> Shows file differences between staging and the last file version
> 
> $ git commit -m "[descriptive message]" <br/>
> Records file snapshots permanently in version history


---


## GROUP CHANGES
Name a series of commits and combine completed efforts

> $ git branch <br/>
> Lists all local branches in the current repository
> 
> $ git branch [branch-name] <br/>
> Creates a new branch
> 
> $ git checkout [branch-name] <br/>
> Switches to the specified branch and updates the working directory
> 
> $ git merge [branch] <br/>
> Combines the specified branch’s history into the current branch
> 
> $ git branch -d [branch-name] <br/>
> Deletes the specified branch


---


## REFACTOR FILENAMES
Relocate and remove versioned files
 
> $ git rm [file] <br/>
> Deletes the file from the working directory and stages the deletion
> 
> $ git rm --cached [file] <br/>
> Removes the file from version control but preserves the file locally
> 
> $ git mv [file-original] [file-renamed] <br/>
> Changes the file name and prepares it for commit


---


## SUPPRESS TRACKING
Exclude temporary files and paths

> *.log <br/>
> build/ <br/>
> temp-* <br/>
> A text file named .gitignore suppresses accidental versioning of
> files and paths matching the specified paterns
> 
>
> $ git ls-files --other --ignored --exclude-standard <br/>
> Lists all ignored files in this project


---


## SAVE FRAGMENTS
Shelve and restore incomplete changes

> $ git stash <br/>
> Temporarily stores all modified tracked files
> 
> $ git stash list <br/>
> Lists all stashed changesets
> 
> $ git stash pop <br/>
> Restores the most recently stashed files
> 
> $ git stash drop <br/>
> Discards the most recently stashed changeset


---


## REVIEW HISTORY
Browse and inspect the evolution of project files

> $ git log
> Lists version history for the current branch
> 
> $ git log --follow [file] <br/>
> Lists version history for a file, including renames
> 
> $ git diff [first-branch]...[second-branch] <br/>
> Shows content differences between two branches
> 
> $ git show [commit] <br/>
> Outputs metadata and content changes of the specified commit


---


## REDO COMMITS
Erase mistakes and craf replacement history

> $ git reset [commit] <br/>
> Undoes all commits afer [commit], preserving changes locally
> 
> $ git reset --hard [commit] <br/>
> Discards all history and changes back to the specified commit


---


## SYNCHRONIZE CHANGES
Register a repository bookmark and exchange version history

> $ git fetch [bookmark] <br/>
> Downloads all history from the repository bookmark
> 
> $ git merge [bookmark]/[branch] <br/>
> Combines bookmark’s branch into current local branch
> 
>
> $ git push [alias] [branch] <br/>
> Uploads all local branch commits to GitHub
> 
> $ git pull <br/>
> Downloads bookmark history and incorporates changes


---


## 参考
* [github-git-cheat-sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)






















