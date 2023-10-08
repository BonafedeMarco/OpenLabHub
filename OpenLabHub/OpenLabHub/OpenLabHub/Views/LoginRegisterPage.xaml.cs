using Prism.Navigation;
using Xamarin.Forms;

namespace OpenLabHub.Views
{
    public partial class LoginRegisterPage : ContentPage
    {
        private readonly INavigationService _navigationService;

        public LoginRegisterPage(INavigationService navigationService)
        {
            InitializeComponent();
            _navigationService = navigationService;

        }

        private void RegisterClicked(object sender, System.EventArgs e)
        {

        }

        private async void LoginClicked(object sender, System.EventArgs e)
        {
            await _navigationService.NavigateAsync("/SideMenuPage", useModalNavigation: false, animated: true);
        }
    }
}
