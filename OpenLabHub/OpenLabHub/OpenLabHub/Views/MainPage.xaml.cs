using OpenLabHub.Models;
using Prism.Ioc;
using Prism.Navigation;
using System;
using System.Collections.Generic;
using System.Linq;
using Xamarin.CommunityToolkit.UI.Views;
using Xamarin.Forms;
using Xamarin.Forms.PancakeView;

namespace OpenLabHub.Views
{
    public partial class MainPage
    {
        List<User> Users { get; set; } = new List<User>();
        public INavigationService _navigationService { get; }

        public MainPage()
        {
            InitializeComponent();

            _navigationService = Prism.PrismApplicationBase.Current.Container.Resolve<INavigationService>();

            //var content = FtpInfoGetter.ParseClientes();

            User User0 = new User()
            {
                username = "OBS Studio",
                ImgUrl = "https://photo.sofun.tw/2013/07/Open-Broadcaster-Software-Logo.png",
                PublicationImgUrl = "https://cdn.cloudflare.steamstatic.com/steam/apps/1905180/ss_f6e4120787729b94b8842d76a617c92bffcf51dc.1920x1080.jpg?t=1692232444",
                description = "Free and open source software for video recording and live streaming.",
                skills = new List<Tag> { new Tag() { name = "Video" }, new Tag() { name = "Streaming" }, new Tag() { name = "2 more..." }, },
                skillsComplete = new List<Tag> { new Tag() { name = "Video" }, new Tag() { name = "Streaming" }, new Tag() { name = "Software" }, new Tag() { name = "Extensible" } },
                LongDescription = "OBS Studio is a free and open-source app for screencasting and live streaming. Written in C/C++ and built with Qt, OBS Studio provides real-time capture, scene composition, recording, encoding, and broadcasting via Real Time Messaging Protocol (RTMP), HLS, SRT, RIST or WebRTC. It can stream videos to any RTMP-supporting destination, including YouTube, Twitch, Instagram and Facebook.\r\n\r\nFor video encoding, OBS Studio can use the x264 transcoder, Intel Quick Sync Video, Nvidia NVENC and the AMD Video Coding Engine to encode video streams into the H.264/MPEG-4 AVC or H.265/HEVC formats. It can encode multiple tracks of audio in the AAC format. More experienced users can choose any codecs and containers available in libavcodec and libavformat, or output the stream to a custom FFmpeg URL.\r\n\r\nOBS Studio also supports plug-ins to extend its functionality."
            };
            Users.Add(User0);

            User User1 = new User()
            {
                id = 1,
                username = "Cloudspotting on Mars",
                ImgUrl = "https://panoptes-uploads.zooniverse.org/project_avatar/072c9492-bc18-402a-be8a-cdc599334cda.jpeg",
                description = "Help us find exotic clouds high in the Martian atmosphere!",
                skills = new List<Tag> { new Tag() { name = "Mars" }, new Tag() { name = "Climate" }, new Tag() { name = "3 more..." }, }

            };
            Users.Add(User1);

            User User2 = new User()
            {
                id = 2,
                username = "ffmpeg",
                ImgUrl = "https://icon-library.com/images/ffmpeg-icon/ffmpeg-icon-20.jpg",
                description = "A complete, cross-platform solution to record, convert and stream audio and video.",
                skills = new List<Tag> { new Tag() { name = "Converter" }, new Tag() { name = "Libraries" }, new Tag() { name = "5 more..." }, }
            };
            Users.Add(User2);

            User User3 = new User()
            {
                id = 3,
                username = "OceanEyes",
                ImgUrl = "https://panoptes-uploads.zooniverse.org/project_avatar/4182eb83-c695-4af7-9b8a-9cf9fe664fa6.jpeg",
                description = "Explore the depths of the ocean to help monitor the Hawaiʻi bottomfish population!",
                skills = new List<Tag> { new Tag() { name = "Ocean" }, new Tag() { name = "Hawaii" }, new Tag() { name = "2 more..." }, }
            };
            Users.Add(User3);

            User User4 = new User()
            {
                id = 4,
                username = "Dark Energy Explorers",
                ImgUrl = "https://panoptes-uploads.zooniverse.org/project_avatar/c667e2dd-4b41-4e4b-ab67-16c697915cec.jpeg",
                description = "Identify distant galaxies to help measure dark energy when the universe was just ~2-3 billion years old",
                skills = new List<Tag> { new Tag() { name = "Galaxies" }, new Tag() { name = "HETDEX" }, new Tag() { name = "4 more..." }, }

            };
            Users.Add(User4);

            User User5 = new User()
            {
                id = 5,
                username = "Neovim",
                ImgUrl = "https://avatars2.githubusercontent.com/u/6471485?v=3&s=400",
                description = "A hyperextensible Vim-based text editor.",
                skills = new List<Tag> { new Tag() { name = "Editor" }, new Tag() { name = "Vim" }, new Tag() { name = "3 more..." }, }
            };
            Users.Add(User5);
            ListaUsuarios.ItemsSource = Users;
        }

        private void LupeCliecked(object sender, EventArgs e)
        {
            Device.BeginInvokeOnMainThread(async () =>
            {
                if (Buscador.IsVisible)
                {
                    await Buscador.FadeTo(0, 500);
                    Buscador.IsVisible = false;
                }
                else
                {
                    Buscador.IsVisible = true;
                    await Buscador.FadeTo(1, 500);
                    entryBusqueda.Focus();
                }
            });
        }

        private void Buscar(object sender, TextChangedEventArgs e) => ListaUsuarios.ItemsSource = Users.FindAll(b => b.username.ToLower().Contains(e.NewTextValue.ToLower()) || b.description.ToLower().Contains(e.NewTextValue.ToLower()));

        private async void MoreTapped(object sender, EventArgs e)
        {
            var pancakeView = (PancakeView)sender;
            var user = (User)pancakeView.BindingContext;

            await _navigationService.NavigateAsync("ProjectDetailsPage", new NavigationParameters { { "User", user } });

        }

        private void FindClicked(object sender, EventArgs e)
        {
            TabEmpresas.IsSelected = true;
        }
    }
}
