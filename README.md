# StateFlowIssue

We have created this sample project to illustrate the issue we are facing working with MutableStateFlow and data binding in the recycler view

This sample app has RecyclerView in the MainActivity. Each item is a simple layout with ConstraintLayout and one TextView inside. Nothing more then that.

For each item of the RecyclerView UserViewModel is created. TextView's text of the recycler row is bound with the nameFlow field of the UserViewModel. 

This nameFlow field is MutableStateFlow

For the onBindViewHolder method of recycler adapter we added logs to see the time spent to do the job. 

We noticed that to bind the first element it takes enormous time 50ms to 150ms. For the following items while scrolling the list we can see that onBindViewHolder might some times take up to 10 ms.

We are not observing anything similar to this when MutableLiveData is used as a type for the nameFlow field. onBindViewHolder takes no more then 4ms. And the same is when nameFlow is a String object

Tested on the Huawei p10 (Android 9) and Samsung Galaxy A21s (Android 11)
