/**
 * <p>Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the <code>10</code> most recent tweets in the user's news feed.</p>
 *
 * <p>Implement the <code>Twitter</code> class:</p>
 *
 * <ul>
 * <li><code>Twitter()</code> Initializes your twitter object.</li>
 * <li><code>void postTweet(int userId, int tweetId)</code> Composes a new tweet with ID <code>tweetId</code> by the user <code>userId</code>. Each call to this function will be made with a unique <code>tweetId</code>.</li>
 * <li><code>List&lt;Integer&gt; getNewsFeed(int userId)</code> Retrieves the <code>10</code> most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be <strong>ordered from most recent to least recent</strong>.</li>
 * <li><code>void follow(int followerId, int followeeId)</code> The user with ID <code>followerId</code> started following the user with ID <code>followeeId</code>.</li>
 * <li><code>void unfollow(int followerId, int followeeId)</code> The user with ID <code>followerId</code> started unfollowing the user with ID <code>followeeId</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
 * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * <strong>Output</strong>
 * [null, null, [5], null, null, [6, 5], null, [5]]
 *
 * <strong>Explanation</strong>
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
 * twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -&gt; [5]. return [5]
 * twitter.follow(1, 2);    // User 1 follows user 2.
 * twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
 * twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -&gt; [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.unfollow(1, 2);  // User 1 unfollows user 2.
 * twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -&gt; [5], since user 1 is no longer following user 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= userId, followerId, followeeId &lt;= 500</code></li>
 * <li><code>0 &lt;= tweetId &lt;= 10<sup>4</sup></code></li>
 * <li>All the tweets have <strong>unique</strong> IDs.</li>
 * <li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>postTweet</code>, <code>getNewsFeed</code>, <code>follow</code>, and <code>unfollow</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 堆（优先队列）</details><br>
 *
 * <div>👍 352, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Design Twitter
 *
 * @author DY
 * @date 2023-06-17 11:04:24
 */
public class PThree55_DesignTwitter {
    public static void main(String[] args) {
        //测试代码
        Twitter solution = new PThree55_DesignTwitter().new Twitter();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {

        private int timestamp = 0;

        private final Map<Integer, User> userMap = new HashMap<>();

        class Tweet {
            private int id; // 记录发表推文的id
            private int time; // 发送推文的时间
            private Tweet next; // 指向下一个推文

            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        class User {
            private final int id; // 记录用户id
            private final Set<Integer> followed = new HashSet<>(); // 关注的用户集合
            private Tweet head; // 最新的推文

            public User(int userId) {
                this.id = userId;
                follow(userId); // 自己关注自己
            }

            public void follow(int followeeId) {
                followed.add(followeeId);
            }

            public void unfollow(int followeeId) {
                if (followeeId != this.id) { // 不可以取关自己
                    followed.remove(followeeId);
                }
            }

            public void postTweet(int tweetId) {
                Tweet tw = new Tweet(tweetId, timestamp);
                ++timestamp;
                tw.next = head; // 将新建的推文插入链表头, 越靠前的推文 time 值越大
                head = tw;
            }

        }

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            User user = userMap.computeIfAbsent(userId, k -> new User(userId));
            user.postTweet(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>(10);
            if (!userMap.containsKey(userId)) {
                return res;
            }
            Set<Integer> followed = userMap.get(userId).followed; // 关注列表
            PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> b.time - a.time); // 根据时间倒排
            for (int followedId : followed) {
                Tweet head = userMap.get(followedId).head; // 关注人的最新推文
                if (head != null) {
                    queue.offer(head);
                }
            }
            while (!queue.isEmpty()) {
                if (res.size() == 10) return res;
                Tweet tw = queue.poll();
                res.add(tw.id);
                if (tw.next != null) {
                    queue.offer(tw.next);
                }
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, k -> new User(followerId));
            userMap.computeIfAbsent(followeeId, k -> new User(followeeId));
            follower.follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
