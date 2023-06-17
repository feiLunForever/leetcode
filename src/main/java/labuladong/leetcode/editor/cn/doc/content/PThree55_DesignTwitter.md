<p>Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the <code>10</code> most recent tweets in the user's news feed.</p>

<p>Implement the <code>Twitter</code> class:</p>

<ul> 
 <li><code>Twitter()</code> Initializes your twitter object.</li> 
 <li><code>void postTweet(int userId, int tweetId)</code> Composes a new tweet with ID <code>tweetId</code> by the user <code>userId</code>. Each call to this function will be made with a unique <code>tweetId</code>.</li> 
 <li><code>List&lt;Integer&gt; getNewsFeed(int userId)</code> Retrieves the <code>10</code> most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be <strong>ordered from most recent to least recent</strong>.</li> 
 <li><code>void follow(int followerId, int followeeId)</code> The user with ID <code>followerId</code> started following the user with ID <code>followeeId</code>.</li> 
 <li><code>void unfollow(int followerId, int followeeId)</code> The user with ID <code>followerId</code> started unfollowing the user with ID <code>followeeId</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
<strong>Output</strong>
[null, null, [5], null, null, [6, 5], null, [5]]

<strong>Explanation</strong>
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -&gt; [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -&gt; [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -&gt; [5], since user 1 is no longer following user 2.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= userId, followerId, followeeId &lt;= 500</code></li> 
 <li><code>0 &lt;= tweetId &lt;= 10<sup>4</sup></code></li> 
 <li>All the tweets have <strong>unique</strong> IDs.</li> 
 <li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>postTweet</code>, <code>getNewsFeed</code>, <code>follow</code>, and <code>unfollow</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 堆（优先队列）</details><br>

<div>👍 352, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=design-twitter" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题比较经典，在特定场景下让你设计算法。其难点在于 `getNewsFeed` 方法，要按照时间线顺序展示所有关注用户的推文，这个方法要用到我在 [单链表的六大解题套路](https://labuladong.github.io/article/fname.html?fname=链表技巧) 解决 [23. 合并K个升序链表](/problems/merge-k-sorted-lists) 的合并多个有序链表的技巧：

你把一个用户发布的所有推文做成一条有序链表（靠近头部的推文是最近发布的），那么只要合并关注用户的推文链表，即可获得按照时间线顺序排序的信息流。

具体看代码吧，我注释比较详细。

**详细题解：[设计朋友圈时间线功能](https://labuladong.github.io/article/fname.html?fname=设计Twitter)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[设计](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121998148662362112)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Twitter {
private:
    // Tweet 类
    class Tweet {
    private:
        int id;
        // 时间戳用于对信息流按照时间排序
        int timestamp;
        // 指向下一条 tweet，类似单链表结构
        Tweet *next;

    public:
        Tweet(int id) {
            this->id = id;
            // 新建一条 tweet 时记录并更新时间戳 
            this->timestamp = globalTime++;
        }

        int getId() {
            return id;
        }

        int getTimestamp() {
            return timestamp;
        }

        Tweet* getNext() {
            return next;
        }

        void setNext(Tweet *next) {
            this->next = next;
        }
    };

    // 用户类
    class User {
    private:
        // 记录该用户的 id 以及发布的 tweet
        int id;
        Tweet *tweetHead;
        // 记录该用户的关注者
        unordered_set<User*> followedUserSet;

    public:
        User(int id) {
            this->id = id;
            this->tweetHead = nullptr;
            this->followedUserSet = unordered_set<User*>();
        }

        int getId() {
            return id;
        }

        Tweet* getTweetHead() {
            return tweetHead;
        }

        unordered_set<User*> getFollowedUserSet() {
            return followedUserSet;
        }

        bool equals(User* other) {
            return this->id == other->id;
        }

        // 关注其他人
        void follow(User *other) {
            followedUserSet.insert(other);
        }

        // 取关其他人
        void unfollow(User *other) {
            followedUserSet.erase(other);
        }

        // 发布一条 tweet
        void post(Tweet *tweet) {
            // 把新发布的 tweet 作为链表头节点
            tweet->setNext(tweetHead);
            tweetHead = tweet;
        }
    };

    // 全局时间戳
    int globalTime = 0;
    // 记录用户 ID 到用户示例的映射
    unordered_map<int, User*> idToUser;

public:
    void postTweet(int userId, int tweetId) {
        // 如果这个用户还不存在，新建用户
        if (idToUser.find(userId) == idToUser.end()) {
            idToUser[userId] = new User(userId);
        }
        User* user = idToUser[userId];
        user->post(new Tweet(tweetId));
    }

    vector<int> getNewsFeed(int userId) {
        vector<int> res = vector<int>();
        if (idToUser.find(userId) == idToUser.end()) {
            return res;
        }
        // 获取该用户关注的用户列表
        User* user = idToUser[userId];
        unordered_set<User*> followedUserSet = user->getFollowedUserSet();
        // 每个用户的 tweet 是一条按时间排序的链表
        // 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
        auto cmp = [](Tweet* a, Tweet* b) -> bool {
            // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
            return b->getTimestamp() < a->getTimestamp();
        };
        priority_queue<Tweet*, vector<Tweet*>, decltype(cmp)> pq(cmp);
        // 该用户自己的 tweet 也在时间线内
        if (user->getTweetHead() != nullptr) {
            pq.push(user->getTweetHead());
        }
        for (User* other : followedUserSet) {
            if (other->getTweetHead() != nullptr) {
                pq.push(other->getTweetHead());
            }
        }
        // 合并多条有序链表
        int count = 0;
        while (!pq.empty() && count < 10) {
            Tweet* tweet = pq.top();
            pq.pop();
            res.push_back(tweet->getId());
            if (tweet->getNext() != nullptr) {
                pq.push(tweet->getNext());
            }
            count++;
        }
        return res;
    }

    void follow(int followerId, int followeeId) {
        // 如果用户还不存在，则新建用户
        if (idToUser.find(followerId) == idToUser.end()) {
            idToUser[followerId] = new User(followerId);
        }
        if (idToUser.find(followeeId) == idToUser.end()) {
            idToUser[followeeId] = new User(followeeId);
        }

        User* follower = idToUser[followerId];
        User* followee = idToUser[followeeId];
        // 关注者关注被关注者
        follower->follow(followee);
    }

    void unfollow(int followerId, int followeeId) {
        if (idToUser.find(followerId) == idToUser.end() || idToUser.find(followeeId) == idToUser.end()) {
            return;
        }
        User* follower = idToUser[followerId];
        User* followee = idToUser[followeeId];
        // 关注者取关被关注者
        follower->unfollow(followee);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Twitter:
    def __init__(self):
        # 全局时间戳
        self.globalTime = 0
        # 记录用户 ID 到用户示例的映射
        self.idToUser = {}

    # Tweet 类
    class Tweet:
        def __init__(self, id: int):
            self.id = id
            # 时间戳用于对信息流按照时间排序
            self.timestamp = Twitter.globalTime
            Twitter.globalTime += 1
            # 指向下一条 tweet，类似单链表结构
            self.next = None

        def get_id(self) -> int:
            return self.id

        def get_timestamp(self) -> int:
            return self.timestamp

        def get_next(self):
            return self.next

        def set_next(self, next_tweet):
            self.next = next_tweet

    # 用户类
    class User:
        def __init__(self, id: int):
            # 记录该用户的 id 以及发布的 tweet
            self.id = id
            self.tweet_head = None
            # 记录该用户的关注者
            self.followed_user_set = set()

        def get_id(self):
            return self.id

        def get_tweet_head(self) -> Tweet:
            return self.tweet_head

        def get_followed_user_set(self):
            return self.followed_user_set

        def __eq__(self, other):
            return self.id == other.id

        # 关注其他人
        def follow(self, other):
            self.followed_user_set.add(other)

        # 取关其他人
        def unfollow(self, other):
            self.followed_user_set.discard(other)

        # 发布一条 tweet
        def post(self, tweet: Tweet):
            # 把新发布的 tweet 作为链表头节点
            tweet.set_next(self.tweet_head)
            self.tweet_head = tweet

    def postTweet(self, userId: int, tweetId: int) -> None:
        # 如果这个用户还不存在，新建用户
        if userId not in self.idToUser:
            self.idToUser[userId] = Twitter.User(userId)
        user = self.idToUser[userId]
        user.post(Twitter.Tweet(tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        if userId not in self.idToUser:
            return res
        # 获取该用户关注的用户列表
        user = self.idToUser[userId]
        followed_user_set = user.get_followed_user_set()
        # 每个用户的 tweet 是一条按时间排序的链表
        # 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
        pq = []
        # 该用户自己的 tweet 也在时间线内
        if user.get_tweet_head():
            heappush(pq, (-user.tweet_head.timestamp, user.get_tweet_head())) # 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
        for other in followed_user_set:
            if other.get_tweet_head():
                heappush(pq, (-other.tweet_head.timestamp, other.get_tweet_head()))
        # 合并多条有序链表
        count = 0
        while pq and count < 10:
            _, tweet = heappop(pq)
            res.append(tweet.get_id())
            if tweet.get_next():
                heappush(pq, (-tweet.get_next().timestamp, tweet.get_next()))
            count += 1
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        # 如果用户还不存在，则新建用户
        if followerId not in self.idToUser:
            self.idToUser[followerId] = Twitter.User(followerId)
        if followeeId not in self.idToUser:
            self.idToUser[followeeId] = Twitter.User(followeeId)

        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        # 关注者关注被关注者
        follower.follow(followee)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.idToUser or followeeId not in self.idToUser:
            return
        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        # 关注者取关被关注者
        follower.unfollow(followee)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Twitter {
    // 全局时间戳
    int globalTime = 0;
    // 记录用户 ID 到用户示例的映射
    HashMap<Integer, User> idToUser = new HashMap<>();

    // Tweet 类
    class Tweet {
        private int id;
        // 时间戳用于对信息流按照时间排序
        private int timestamp;
        // 指向下一条 tweet，类似单链表结构
        private Tweet next;

        public Tweet(int id) {
            this.id = id;
            // 新建一条 tweet 时记录并更新时间戳 
            this.timestamp = globalTime++;
        }

        public int getId() {
            return id;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public Tweet getNext() {
            return next;
        }

        public void setNext(Tweet next) {
            this.next = next;
        }
    }

    // 用户类
    class User {
        // 记录该用户的 id 以及发布的 tweet
        private int id;
        private Tweet tweetHead;
        // 记录该用户的关注者
        private HashSet<User> followedUserSet;

        public User(int id) {
            this.id = id;
            this.tweetHead = null;
            this.followedUserSet = new HashSet<>();
        }

        public int getId() {
            return id;
        }

        public Tweet getTweetHead() {
            return tweetHead;
        }

        public HashSet<User> getFollowedUserSet() {
            return followedUserSet;
        }

        public boolean equals(User other) {
            return this.id == other.id;
        }

        // 关注其他人
        public void follow(User other) {
            followedUserSet.add(other);
        }

        // 取关其他人
        public void unfollow(User other) {
            followedUserSet.remove(other);
        }

        // 发布一条 tweet
        public void post(Tweet tweet) {
            // 把新发布的 tweet 作为链表头节点
            tweet.setNext(tweetHead);
            tweetHead = tweet;
        }
    }

    public void postTweet(int userId, int tweetId) {
        // 如果这个用户还不存在，新建用户
        if (!idToUser.containsKey(userId)) {
            idToUser.put(userId, new User(userId));
        }
        User user = idToUser.get(userId);
        user.post(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!idToUser.containsKey(userId)) {
            return res;
        }
        // 获取该用户关注的用户列表
        User user = idToUser.get(userId);
        Set<User> followedUserSet = user.getFollowedUserSet();
        // 每个用户的 tweet 是一条按时间排序的链表
        // 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
            // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
            return b.timestamp - a.timestamp;
        });
        // 该用户自己的 tweet 也在时间线内
        if (user.getTweetHead() != null) {
            pq.offer(user.getTweetHead());
        }
        for (User other : followedUserSet) {
            if (other.getTweetHead() != null) {
                pq.offer(other.tweetHead);
            }
        }
        // 合并多条有序链表
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.getId());
            if (tweet.getNext() != null) {
                pq.offer(tweet.getNext());
            }
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        // 如果用户还不存在，则新建用户
        if (!idToUser.containsKey(followerId)) {
            idToUser.put(followerId, new User(followerId));
        }
        if (!idToUser.containsKey(followeeId)) {
            idToUser.put(followeeId, new User(followeeId));
        }

        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);
        // 关注者关注被关注者
        follower.follow(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!idToUser.containsKey(followerId) || !idToUser.containsKey(followeeId)) {
            return;
        }
        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);
        // 关注者取关被关注者
        follower.unfollow(followee);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

type Twitter struct {
    // 全局时间戳
    globalTime int
    // 记录用户 ID 到用户示例的映射
    idToUser map[int]*User
}

// Tweet 类
type Tweet struct {
    id        int
    // 时间戳用于对信息流按照时间排序
    timestamp int
    // 指向下一条 tweet，类似单链表结构
    next      *Tweet
}

func NewTweet(id int) *Tweet {
    return &Tweet{
        id:        id,
        timestamp: globalTime,
    }
}

// User 类
type User struct {
    // 记录该用户的 id 以及发布的 tweet
    id            int
    tweetHead     *Tweet
    // 记录该用户的关注者
    followedUsers map[int]*User
}

func NewUser(id int) *User {
    return &User{
        id:            id,
        followedUsers: make(map[int]*User),
    }
}

func (u *User) Post(tweet *Tweet) {
    // 把新发布的 tweet 作为链表头节点
    tweet.next = u.tweetHead
    u.tweetHead = tweet
}

func (u *User) Follow(other *User) {
    u.followedUsers[other.id] = other
}

func (u *User) Unfollow(other *User) {
    delete(u.followedUsers, other.id)
}

func (u *User) Eq(other *User) bool {
    return u.id == other.id
}

func (t *Twitter) PostTweet(userId int, tweetId int) {
    // 如果这个用户还不存在，新建用户
    if _, ok := t.idToUser[userId]; !ok {
        t.idToUser[userId] = NewUser(userId)
    }
    user := t.idToUser[userId]
    user.Post(NewTweet(tweetId))
}

func (t *Twitter) GetNewsFeed(userId int) []int {
    res := make([]int, 0)
    if _, ok := t.idToUser[userId]; !ok {
        return res
    }
    // 获取该用户关注的用户列表
    user := t.idToUser[userId]
    followedUserSet := user.followedUsers
    // 每个用户的 tweet 是一条按时间排序的链表
    // 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
    pq := make(PriorityQueue, 0)
    // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
    heap.Init(&pq)
    // 该用户自己的 tweet 也在时间线内
    if user.tweetHead != nil {
        heap.Push(&pq, user.tweetHead)
    }
    for _, other := range followedUserSet {
        if other.tweetHead != nil {
            heap.Push(&pq, other.tweetHead)
        }
    }
    // 合并多条有序链表
    count := 0
    for pq.Len() > 0 && count < 10 {
        tweet := heap.Pop(&pq).(*Tweet)
        res = append(res, tweet.id)
        if tweet.next != nil {
            heap.Push(&pq, tweet.next)
        }
        count++
    }
    return res
}

func (t *Twitter) Follow(followerId int, followeeId int) {
    // 如果用户还不存在，则新建用户
    if _, ok := t.idToUser[followerId]; !ok {
        t.idToUser[followerId] = NewUser(followerId)
    }
    if _, ok := t.idToUser[followeeId]; !ok {
        t.idToUser[followeeId] = NewUser(followeeId)
    }

    follower := t.idToUser[followerId]
    followee := t.idToUser[followeeId]
    // 关注者关注被关注者
    follower.Follow(followee)
}

func (t *Twitter) Unfollow(followerId int, followeeId int) {
    if _, ok := t.idToUser[followerId]; !ok || _, ok := t.idToUser[followeeId]; !ok {
        return
    }
    follower := t.idToUser[followerId]
    followee := t.idToUser[followeeId]
    // 关注者取关被关注者
    follower.Unfollow(followee)
}

type PriorityQueue []*Tweet

func (pq PriorityQueue) Len() int {
    return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
    return pq[i].timestamp > pq[j].timestamp
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Pop() interface{} {
    n := len(*pq)
    item := (*pq)[n-1]
    *pq = (*pq)[:n-1]
    return item
}

func (pq *PriorityQueue) Push(item interface{}) {
    *pq = append(*pq, item.(*Tweet))
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var Twitter = function() {
    // 全局时间戳
    let globalTime = 0;
    // 记录用户 ID 到用户示例的映射
    const idToUser = new Map();

    // Tweet 类
    function Tweet(id) {
        this.id = id;
        // 时间戳用于对信息流按照时间排序
        this.timestamp = globalTime++;
        // 指向下一条 tweet，类似单链表结构
        this.next = null;
    }

    // 用户类
    function User(id) {
        // 记录该用户的 id 以及发布的 tweet
        this.id = id;
        this.tweetHead = null;
        // 记录该用户的关注者
        this.followedUserSet = new Set();
    }

    User.prototype.equals = function(other) {
        return this.id === other.id;
    }

    // 关注其他人
    User.prototype.follow = function(other) {
        this.followedUserSet.add(other);
    }

    // 取关其他人
    User.prototype.unfollow = function(other) {
        this.followedUserSet.delete(other);
    }

    // 发布一条 tweet
    User.prototype.post = function(tweet) {
        // 把新发布的 tweet 作为链表头节点
        tweet.next = this.tweetHead;
        this.tweetHead = tweet;
    }

    this.postTweet = function(userId, tweetId) {
        // 如果这个用户还不存在，新建用户
        if (!idToUser.has(userId)) {
            idToUser.set(userId, new User(userId));
        }
        const user = idToUser.get(userId);
        user.post(new Tweet(tweetId));
    };

    this.getNewsFeed = function(userId) {
        const res = [];
        if (!idToUser.has(userId)) {
            return res;
        }
        // 获取该用户关注的用户列表
        const user = idToUser.get(userId);
        const followedUserSet = user.followedUserSet;
        // 每个用户的 tweet 是一条按时间排序的链表
        // 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
        const pq = new PriorityQueue((a, b) => {
            // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
            return b.timestamp - a.timestamp;
        });
        // 该用户自己的 tweet 也在时间线内
        if (user.tweetHead !== null) {
            pq.offer(user.tweetHead);
        }
        for (const other of followedUserSet) {
            if (other.tweetHead !== null) {
                pq.offer(other.tweetHead);
            }
        }
        // 合并多条有序链表
        let count = 0;
        while (!pq.isEmpty() && count < 10) {
            const tweet = pq.poll();
            res.push(tweet.id);
            if (tweet.next !== null) {
                pq.offer(tweet.next);
            }
            count++;
        }
        return res;
    };

    this.follow = function(followerId, followeeId) {
        // 如果用户还不存在，则新建用户
        if (!idToUser.has(followerId)) {
            idToUser.set(followerId, new User(followerId));
        }
        if (!idToUser.has(followeeId)) {
            idToUser.set(followeeId, new User(followeeId));
        }

        const follower = idToUser.get(followerId);
        const followee = idToUser.get(followeeId);
        // 关注者关注被关注者
        follower.follow(followee);
    };

    this.unfollow = function(followerId, followeeId) {
        if (!idToUser.has(followerId) || !idToUser.has(followeeId)) {
            return;
        }
        const follower = idToUser.get(followerId);
        const followee = idToUser.get(followeeId);
        // 关注者取关被关注者
        follower.unfollow(followee);
    };
};

// 优先队列实现
class PriorityQueue {
    constructor(comparator) {
        this.heap = [];
        this.comparator = comparator;
    }

    /**
     * 上浮操作
     * @param {number} index - 上浮节点的下标
     */
    swim(index) {
        let currentIndex = index;
        while (currentIndex > 0) {
            const parentIndex = Math.floor((currentIndex - 1) / 2);
            if (this.comparator(this.heap[currentIndex], this.heap[parentIndex]) >= 0) {
                break;
            }
            [this.heap[currentIndex], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[currentIndex]];
            currentIndex = parentIndex;
        }
    }

    /**
     * 下沉操作
     * @param {number} index - 下沉节点的下标
     */
    sink(index) {
        let currentIndex = index;
        while (currentIndex * 2 + 1 < this.heap.length) {
            const leftIndex = currentIndex * 2 + 1;
            const rightIndex = currentIndex * 2 + 2 < this.heap.length ? currentIndex * 2 + 2 : leftIndex;
            const smallerIndex = this.comparator(this.heap[leftIndex], this.heap[rightIndex]) <= 0 ? leftIndex : rightIndex;
            if (this.comparator(this.heap[currentIndex], this.heap[smallerIndex]) <= 0) {
                break;
            }
            [this.heap[currentIndex], this.heap[smallerIndex]] = [this.heap[smallerIndex], this.heap[currentIndex]];
            currentIndex = smallerIndex;
        }
    }

    /**
     * 插入元素
     * @param {*} value - 插入的值
     */
    offer(value) {
        this.heap.push(value);
        this.swim(this.heap.length - 1);
    }

    /**
     * 弹出堆顶元素
     * @return {*} 堆顶元素
     */
    poll() {
        if (this.size() === 0) {
            return null;
        }
        if (this.size() === 1) {
            return this.heap.pop();
        }
        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.sink(0);
        return top;
    }

    /**
     * 获取堆大小
     * @return {number} 堆大小
     */
    size() {
        return this.heap.length;
    }
}
```

</div></div>
</div></div>

</details>
</div>



