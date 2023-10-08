using Prism.Navigation;
using Xamarin.Forms;

namespace OpenLabHub.Views
{
    public partial class SideMenuPage : MasterDetailPage
    {
        private readonly INavigationService _navigationService;

        public SideMenuPage(INavigationService navigationService)
        {
            InitializeComponent();
            _navigationService = navigationService;
        }

        private void ProfileClicked(object sender, System.EventArgs e)
        {

        }

        private async void HomeClicked(object sender, System.EventArgs e) => IsPresented = false;

        private void SettingsClicked(object sender, System.EventArgs e)
        {

        }

        private async void LogOutClicked(object sender, System.EventArgs e)
        {
            IsPresented = false;
            await _navigationService.NavigateAsync("/LoginRegisterPage", useModalNavigation: false, animated: true);
        }

        private void ProjectsClicked(object sender, System.EventArgs e)
        {

        }
    }
}