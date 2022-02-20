using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmTestRandom : Form
    {
        int i = 0;
        int ball = 0;
        int rez;
        public int QuaCount;
        public int minValue;
        public int maxValue;
        public int StepValue = 1;
        public List<string> strPlayList = new List<string> { };
        public static int countForm;
        public FrmTestRandom()
        {
            countForm = 0;
            InitializeComponent();
            
        }

        private void frmTestRandom_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
            countForm = 1;
            minValue = FrmConfig.MinZnach;
            maxValue = FrmConfig.MaxZnach;
            StepValue = FrmConfig.steep;
            QuaCount = FrmConfig.Kil;
            txtBoxRez.Select();
            genQuation();
            
        }

        private void genQuation()
        {
            if (minValue != 0 && maxValue != 0 && StepValue != 0 && QuaCount != 0)
            {
                Random r = new Random();
                int r1 = r.Next(minValue / StepValue, maxValue / StepValue) * StepValue;
                int r2 = r.Next(minValue / StepValue, maxValue / StepValue) * StepValue;
                if (r2 > r1) { int t = r1; r1 = r2; r2 = t; }

                if (FrmConfig.dia == "Додавання")
                {
                    lblShow.Text = r1.ToString() + "+" + r2.ToString() + "=";
                    rez = r1 + r2;

                }
                else if (FrmConfig.dia == "Віднімання")
                {
                    lblShow.Text = r1.ToString() + "-" + r2.ToString() + "=";
                    rez = r1 - r2;
                }
                else if (FrmConfig.dia == "Ділення")
                {



                    if (r2 == 0) { r2 = minValue; }

                    while (((r1 % r2) != 0))
                    {
                            r1 = r.Next(minValue / StepValue, maxValue / StepValue)  * StepValue;
                            r2 = r.Next(minValue / StepValue, maxValue / StepValue) * StepValue;

                        if(r2 > r1) { int t = r1; r1 = r2; r2 = t; }
                        if (r2 == 0) { r2 = minValue; }
                    }
                    int k = 9;
                    lblShow.Text = r1.ToString() + ":" + r2.ToString() + "=";
                            rez = r1 / r2;
                       
                    
                }
                else if (FrmConfig.dia == "Множення")
                {
                    lblShow.Text = r1.ToString() + "*" + r2.ToString() + "=";
                    rez = r1 * r2;
                }
                    i++;


                    if (txtBoxRez.Text != null && txtBoxRez.ToString() == rez.ToString())
                    {
                        ball += 1;
                    }

                    var numberPlayList = player.playlistCollection.newPlaylist("MyPlayList");
                    numberPlayList.clear();
                    strPlayList.Clear();
                    addNumberToPlaylist(r1);
                    /////// операція
                    //  string[] strOper = { "+", "-", "Поділити", "Помножити" };
                    //numOper = r.Next(0, 3);
                    //  strPlayList.Add("Data\\Sound\\" + strOper[numOper] + ".mp3");
                    strPlayList.Add("Data\\Sound\\" + FrmConfig.dia + ".mp3");
                    ///////////////////////

                    /////////// друге  число
                    addNumberToPlaylist(r2);
                    //    numberPlayList.appendItem(player.newMedia("Data\\Sound\\" + c.ToString() + ".mp3"));

                    strPlayList.Add("Data\\Sound\\=.mp3");


                    foreach (string p in strPlayList)
                    {
                        numberPlayList.appendItem(player.newMedia(p));
                    }

                    player.currentPlaylist = numberPlayList;
                    PlaySound();
                
            }
        }
        private void PlaySound()
        {
            try
            {
              
                player.settings.volume = 100;
                player.Ctlcontrols.play();

            }

            catch (Exception ex) { }

        }
        public void addNumberToPlaylist(int GenNum)
        {
            string strGenNum = GenNum.ToString();

            if ((GenNum < 11) || (GenNum > 19))
            {
                for (int i = 0; i < strGenNum.Length; i++)
                {

                    string s = strGenNum.Substring(i, 1);

                    int c = (int)(Convert.ToInt32(s) * Math.Pow(10, strGenNum.Length - i - 1));

                    if (!((c == 0) && (GenNum != 0)))
                    {
                        strPlayList.Add("Data\\Sound\\" + c.ToString() + ".mp3");
                    }
                }
            }
            else { strPlayList.Add("Data\\Sound\\" + strGenNum + ".mp3"); }


        }


        //************************
        private void button1_Click(object sender, EventArgs e)
        {
            if (txtBoxRez.Text == "")
            {
                MessageBox.Show("Введіть відповідь");
            }
            else
            {
                if (txtBoxRez.Text == rez.ToString())
                {
                    ball += 1;
                }
                if (i == QuaCount)
                {
                    float rez = QuaCount / 2;
                    btnNext.Hide();
                    txtBoxRez.Hide();
                    lblShow.BackColor = Color.AliceBlue;
                    lblShow.Top = 175;
                    lblShow.Left = +80;
                    pctBoxFon.Image = Image.FromFile("Data\\Achive\\Amazing.gif");
                    lblShow.Font = new Font("Microsoft Times New Roman", 11, FontStyle.Italic);
                    lblShow.Text = "Молодець, правильних - " +  ball.ToString();
                    

                   // MessageBox.Show("Ваш бал за тест - " + ball.ToString());
                   // countForm = 0;
                   
                }
                else
                {
                    txtBoxRez.Clear();
                    genQuation();
                    txtBoxRez.Focus();
                }
            }
           // Show.Text = "";
            
        }

        private void txtBoxRez_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxRez_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (!Char.IsDigit(number) && number != 8) // цифры и клавиша BackSpace
            {
                e.Handled = true;
            }
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            countForm = 0;
            this.Close();
            FrmConfig start = new FrmConfig();
            start.Show();
        }

        private void FrmTestRandom_ResizeEnd(object sender, EventArgs e)
        {
            Opacity = 1;
        }

        private void FrmTestRandom_ResizeBegin(object sender, EventArgs e)
        {
            Opacity = 0.5;
        }
    }
}
