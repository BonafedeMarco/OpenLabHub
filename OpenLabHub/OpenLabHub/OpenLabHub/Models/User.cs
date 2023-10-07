using System;
using System.Collections.Generic;
using System.Text;

namespace OpenLabHub.Models
{
    public class MainUserInfo
    {
        public User UserInfo { get; set; }
        public MainUserState MainState { get; set; }
    }

    public enum MainUserState { Unlogged, Pending, Logged }

    public class User
    {
        public string username { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public string description { get; set; }
        public HashSet<Project> projects { get; set; }
        public HashSet<Application> application { get; set; }
        public HashSet<Tag> skills { get; set; }
    }
}
