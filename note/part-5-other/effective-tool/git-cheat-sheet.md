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