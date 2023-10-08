using OpenLabHub.Models;
using Prism.Navigation;
using System.Collections.Generic;
using Xamarin.Forms;

namespace OpenLabHub.Views
{
    public partial class ProjectDetailsPage : ContentPage, INavigationAware
    {
        User User = new User();
        List<Tag> skillsComplete = new List<Tag>();

        private readonly INavigationService _navigationService;

        public ProjectDetailsPage(INavigationService navigationService)
        {
            InitializeComponent();
            _navigationService = navigationService;
        }

        private async void BackClicked(object sender, System.EventArgs e) => await _navigationService.NavigateAsync("/SideMenuPage", useModalNavigation: false, animated: true);


        public void OnNavigatedTo(INavigationParameters parameters)
        {
            if (parameters.ContainsKey("User"))
            {
                User = parameters.GetValue<User>("User");

                LblUsername.Text = User.username;
                LblShortDesc.Text = User.description;
                ImgUserPic.Source = User.ImgUrl;
                LblLongDesc.Text = User.LongDescription;
                ImgProject.Source = User.PublicationImgUrl;
                CollectionSkills.ItemsSource = User.skillsComplete;
            }
        }

        public void OnNavigatedFrom(INavigationParameters parameters) { }

        private void JoinClicked(object sender, System.EventArgs e)
        {
            JoinBtn.Text = "Request Sent!";
            JoinBtn.IsEnabled = false;
            JoinBtn.BackgroundColor = Color.FromHex("#B1D8B7");
        }
    }
}
