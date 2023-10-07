using System;
using System.Collections.Generic;
using System.Text;

namespace OpenLabHub.Models
{
    public class Project
    {
        public string title { get; set; }
        public string description { get; set; }
        private DateTime dateCreated { get; set; }
        public string state { get; set; }
        public string imageUrl { get; set; }
        public HashSet<ProjectTag> projectTags { get; set; }
        public User user { get; set; }
        

    }
    public class ProjectTag
    {
        public Project project { get; set; }
        public float weight { get; set; }
        public Tag tag { get; set; }
    }
}
